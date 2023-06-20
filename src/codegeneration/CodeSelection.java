/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ast.*;
import main.*;
import visitor.*;
import ast.definition.*;
import ast.expression.*;
import ast.type.*;
import ast.statement.*;


public class CodeSelection extends DefaultVisitor {
    enum CodeFunction {
        ADDRESS, EXECUTE, VALUE,DEFINE
    }
    private Map<String, String> instruction=new HashMap<String,String>();
    private Map<String, Integer> variant=new HashMap<String, Integer>();
    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
        instruction.put("+","add");
        instruction.put("-","sub");
        instruction.put("*","mul");
        instruction.put("/","div");
        instruction.put("%","mod");
        instruction.put(">","gt");
        instruction.put(">=","ge");
        instruction.put("==","eq");
        instruction.put("<=","le");
        instruction.put("<","lt");
        instruction.put("!=","ne");
        variant.put("println",10);//Asici for \n
        variant.put("printsp",32);//ascci for whitespace


    }

    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {
        out("#SOURCE \""+sourceFile+"\"");
        out("call main");
        out("halt");
        for (Definition definition: node.getDefinitions() ) {
            definition.accept(this,CodeFunction.DEFINE);
        }
        return null;
    }

    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {
        if (node.isGlobal()) {
            out("#GLOBAL " + node.getName() +" : "+node.getType() );
        } else {
            out("\t'" + node.getName() + ":" + node.getType());
        };
        return null;
    }

    //	class FunctionDefinition { String name;  List<VarDefinition> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {
        out("#LINE "+node.getStart().getLine());
        out(node.getName()+":");
        int parametersSize=node.getParameterSize();
        if (node.getParameters() != null) {
            if(node.getParameterSize()>0){
                out("'Parameters:");
                for (VarDefinition child : node.getParameters())
                    child.accept(this, CodeFunction.DEFINE);
            }
        }
        int returnSize=0;//in case it's a void function
        if (node.getReturnType() != null) {
            node.getReturnType().accept(this, param);
            returnSize=node.getReturnType().getSize();
        }
        int localDefsSize=0;
        if (node.getLocalDefs() != null) {
            if(node.getLocalDefs().size()>0){

                out("'Local Definitions:");
                for (VarDefinition child : node.getLocalDefs()) {
                    child.accept(this, CodeFunction.DEFINE);

                }
                localDefsSize=-node.getLocalDefs().get(node.getLocalDefs().size()-1).getDirection();
                out("enter "+localDefsSize);
            }
        }
        if (node.getStatements() != null) {
            out("'Body");
            for (Statement child : node.getStatements()) {
                if(child.getStart()!=null) {out("#LINE "+child.getStart().getLine());}
              child.accept(this, CodeFunction.EXECUTE);
            }
        }

        if(!node.hasReturnStatement() && node.getReturnType() instanceof  VoidType) {
            //An implicit return will only be generated when the function is voidType)
            if (parametersSize + localDefsSize + returnSize == 0) {
                out("RET ");
            } else {
                out("RET " + returnSize + "," + localDefsSize + "," + parametersSize);
            }
        }
       return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        out("#TYPE " + node.getName() + ":{");
        if (node.getFields() != null) {
            for (StructField child : node.getFields())
                out("\t" + child.getName() + ":" + child.getType());
        }
        out("}");
        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {
        out("\t' "+node.getName()+" :"+node.getType());
        return null;
    }

    //	class Print { Expression expression;  String variant; }
    public Object visit(Print node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, CodeFunction.VALUE);
        out("out"+node.getExpression().getType().getSuffix());
       if(!node.getVariant().equals("print")){
           out("pushb "+variant.get(node.getVariant()));
           out("outb");
        }
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, CodeFunction.ADDRESS);
        out("in"+node.getExpression().getType().getSuffix());
        out("store"+node.getExpression().getType().getSuffix() );
        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {
        incrementLabel();
        int currentLabel=getLabel();
        //There's no need to have an ifStart label since there is no recursivity
        if (node.getCondition() != null)
            node.getCondition().accept(this, CodeFunction.VALUE);

        if (node.getElseBody().isEmpty()) {
            out("jz ifEnd" + currentLabel);
        } else {
            out("jz elseBody" + currentLabel);
        }

        if (node.getBody() != null) {
            for (Statement child : node.getBody()) {
                if(child.getStart()!=null) {out("#LINE "+child.getStart().getLine());};
                child.accept(this, CodeFunction.EXECUTE);
            }
        }
        if (node.getElseBody() != null) {
            if(!node.getElseBody().isEmpty()) {
                out("jmp ifEnd" + currentLabel); //If there's no elseBody, this jump is not necessary
                out("elseBody" + currentLabel+ ":");
                for (Statement child : node.getElseBody()) {
                    if (child.getStart() != null) {
                        out("#LINE " + child.getStart().getLine());
                    }
                    child.accept(this, CodeFunction.EXECUTE);
                }
            }
        }
        out("ifEnd"+currentLabel+":");

        return null;
    }

    //	class While { Expression condition;  List<Statement> body; }
    public Object visit(While node, Object param) {
        incrementLabel();
        int currentLabel=getLabel();
        // super.visit(node, param);
       out("whileStart"+currentLabel+" :");
        if (node.getCondition() != null)
            node.getCondition().accept(this, CodeFunction.VALUE);
        out("jz whileEnd"+currentLabel);
        if (node.getBody() != null) {
            for (Statement child : node.getBody()) {
                if (child.getStart() != null) {
                    out("#LINE " + child.getStart().getLine());
                }
                ;
                child.accept(this, CodeFunction.EXECUTE);
            }
        }
        out("jmp whileStart"+currentLabel);
        out("whileEnd"+currentLabel+":");

        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.ADDRESS);
        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out("store"+node.getLeft().getType().getSuffix());
        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, CodeFunction.VALUE);
        FunctionDefinition definition=node.getFunctionDefinition();
        int localDefsSize=definition.getLocalDefs().size()>0?-definition.getLocalDefs().get(definition.getLocalDefs().size()-1).getDirection():0;;
        int parametersSize=definition.getParameterSize();
        int retSize=definition.getReturnType().getSize();
        if(retSize+localDefsSize+parametersSize==0){
            out("RET ");}
        else{
                out("RET "+retSize+","+localDefsSize+","+parametersSize);
        }
        return null;
    }

    //	class InvocationStatement { String name;  List<Expression> parameters; }
    public Object visit(InvocationStatement node, Object param) {
        if (node.getParameters() != null)
            for (Expression child : node.getParameters())
                child.accept(this, CodeFunction.VALUE);
        out("call "+node.getName());
        //If the function has a return value , we have to make sure no garbage is left.
       if( !(node.getDefinition().getReturnType() instanceof VoidType)){
               out("pop",node.getDefinition().getReturnType());
           }
        return null;
    }

    //	class Invocation { String name;  List<Expression> parameters; }
    public Object visit(Invocation node, Object param) {
        if (node.getParameters() != null)
        for (Expression child : node.getParameters())
            child.accept(this, CodeFunction.VALUE);
        out("call "+node.getName());
        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.VALUE);

        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator())+node.getRight().getType().getSuffix());
        return null;
    }

    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.VALUE);

        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator())+ node.getLeft().getType().getSuffix());
        return null;
    }

    //	class And { Expression left;  Expression right; }
    public Object visit(And node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.VALUE);

        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out("and");
        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.VALUE);

        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out("or");

        return null;
    }

    //	class Not { Expression expression; }
    public Object visit(Not node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, CodeFunction.VALUE);
        out("not");
        return null;
    }

    //	class Cast { Type type;  Expression expression; }
    public Object visit(Cast node, Object param) {
        node.getExpression().accept(this,CodeFunction.VALUE);
        Type typeToCastTo=node.getType(), typeCasted=node.getExpression().getType();
        if(typeToCastTo instanceof  FloatType && typeCasted instanceof CharType || typeToCastTo instanceof  CharType && typeCasted instanceof  FloatType){
            out(typeCasted.getSuffix()+"2i");
            out("i2"+typeToCastTo.getSuffix());
        }else{
            out(typeCasted.getSuffix()+"2"+typeToCastTo.getSuffix());
        }
        return null;
    }

    //	class ArrayAccess { Expression array;  Expression position; }
    public Object visit(ArrayAccess node, Object param) {

        if (node.getArray() != null)
            node.getArray().accept(this, CodeFunction.ADDRESS);

        if (node.getPosition() != null)
            node.getPosition().accept(this, CodeFunction.VALUE);
//El AST viene decorado de comprobación de tipos , de tal forma que el tipo del nodo array access es igual al tipo de los elementos que conforman la array.
            out("pushi "+node.getType().getSize());
            out("muli");
            out("addi");

     if(param.equals(CodeFunction.VALUE)) {
            out("load"+node.getType().getSuffix());
        }
        return null;
    }

    //	class StructFieldAccess { Expression struct;  String field; }
    public Object visit(StructFieldAccess node, Object param) {
        if (node.getStruct() != null)
            node.getStruct().accept(this, CodeFunction.ADDRESS);

        StructType struct = (StructType) (node.getStruct().getType());
        StructField field= (StructField) (struct.getDefinition().getField(node.getField()));

        out("pushi "+field.getDirection());
        out("addi");

        if(param.equals(CodeFunction.VALUE)) {
            //For example, when we use a structFieldAccess as a left expression in an assigment we DO not call it's VALUE.
            out("load" + field.getType().getSuffix());
        }
        return null;
    }
    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {
        if(node.getDefinition().isGlobal()){
            out("pusha "+node.getDefinition().getDirection());
        }else{
            out("push BP");
            out("pushi "+node.getDefinition().getDirection());
            out("addi");
        }
        if(param.equals(CodeFunction.VALUE)){
            out("load"+node.getType().getSuffix());
        }

        return null;
    }

    //	class LiteralInt { Int value; }
    public Object visit(LiteralInt node, Object param) {
        out("pushi "+node.getValue() );
        return null;
    }

    //	class LiteralFloat { Double value; }
    public Object visit(LiteralFloat node, Object param) {
        out("pushf "+node.getValue() );
        return null;
    }

    //	class LiteralChar { String value; }
    public Object visit(LiteralChar node, Object param) {
        out("pushb "+((int)(node.getValue())));
        return null;
    }


    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    // Imprime una línea en el fichero de salida
     private void out(String instruction) {
        writer.println(instruction);
    }
      private void out(String instruction,Type type) {
        writer.println(instruction+type.getSuffix());
    }
    private void line(AST node) {
        line(node.getEnd());
    }

    private void line(Position pos) {
        if (pos != null)
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }

    private int label=0; //To be used as a suffix.
    private int getLabel(){
        return this.label;
    }

    /**
     *
     */
    private void incrementLabel(){
        this.label+=1;
    }

    private PrintWriter writer;
    private String sourceFile;
}
