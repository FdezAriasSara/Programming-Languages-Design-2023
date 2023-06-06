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
    private Map<String, String> variant=new HashMap<String,String>();
    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
        instruction.put("+","add");
        instruction.put("-","sub");
        instruction.put("*","mul");
        instruction.put("/","div");
        instruction.put(">","gt");
        instruction.put(">=","ge");
        instruction.put("==","eq");
        instruction.put("<=","le");
        instruction.put("<","lt");
        instruction.put("!=","ne");
        variant.put("ln","\n");
        variant.put("sp"," ");


    }

    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {
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
            out("#GLOBAL " + node.getName() + ":" + node.getType());
        } else {
            out("\t'" + node.getName() + ":" + node.getType());
        };
        return null;
    }

    //	class FunctionDefinition { String name;  List<VarDefinition> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {
        out("#LINE "+node.getStart().getLine());
        out(node.getName()+":");
        int parametersSize=0;
        if (node.getParameters() != null) {
            if(node.getParameters().size()>0){
                parametersSize=node.getParameters().get(0).getDirection();
            }
            out("'Parameters:");
            for (VarDefinition child : node.getParameters())
                child.accept(this, CodeFunction.DEFINE);
        }
        int returnSize=0;//in case it's a void function
        if (node.getReturnType() != null) {
            node.getReturnType().accept(this, param);
            returnSize=node.getReturnType().getSize();
        }

        int localDefsSize=0;
        if (node.getLocalDefs() != null) {

            if(node.getLocalDefs().size()>0){
                localDefsSize=node.getLocalDefs().get(node.getLocalDefs().size()-1).getDirection();
            }

            for (VarDefinition child : node.getLocalDefs()) {

                child.accept(this, CodeFunction.DEFINE);
            }
            out("enter "+localDefsSize);
        }
        if (node.getStatements() != null) {
            out("'Body");
            for (Statement child : node.getStatements()) {
                child.accept(this, CodeFunction.EXECUTE);
            }
        }

        if(parametersSize+localDefsSize+returnSize==0){
            out("RET ");
        }else{
            out("RET "+returnSize+","+localDefsSize+","+parametersSize);
        }

       return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        out("' Struct "+node.getName());
        if (node.getFields() != null) {
            for (StructField child : node.getFields())
                child.accept(this, CodeFunction.DEFINE);
        }
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
        out("out"+node.getExpression().getType()+variant.get(node.getVariant()));
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, CodeFunction.ADDRESS);
        out("in"+node.getExpression().getType());
        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {
        if (node.getCondition() != null)
            node.getCondition().accept(this, CodeFunction.VALUE);
        out("jz elseBody"+getLabel());
        if (node.getBody() != null) {
            for (Statement child : node.getBody())
                child.accept(this, CodeFunction.EXECUTE);
        }
        out("jmp ifEnd"+label);
        if (node.getElseBody() != null) {
            out("elseBody" + label+":");
            for (Statement child : node.getElseBody())
                child.accept(this, CodeFunction.EXECUTE);
        }
        out("ifEnd"+label+":");

        return null;
    }

    //	class While { Expression condition;  List<Statement> body; }
    public Object visit(While node, Object param) {
        // super.visit(node, param);
       out("whileStart"+getLabel()+":");
        if (node.getCondition() != null)
            node.getCondition().accept(this, CodeFunction.VALUE);
        out("jz whileEnd"+label);
        if (node.getBody() != null)
            for (Statement child : node.getBody())
                child.accept(this, CodeFunction.EXECUTE);
        out("jmp whileStart"+label);
        out("whileEnd"+label+":");
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
        return null;
    }

    //	class InvocationStatement { String name;  List<Expression> parameters; }
    public Object visit(InvocationStatement node, Object param) {
        if (node.getParameters() != null)
            for (Expression child : node.getParameters())
                child.accept(this, CodeFunction.VALUE);
        out("call "+node.getName());
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
        out(instruction.get(node.getOperator()));
        return null;
    }

    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, CodeFunction.VALUE);

        if (node.getRight() != null)
            node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()));
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
        out("Load"+node.getArray().getType().getSuffix());
        return null;
    }

    //	class StructFieldAccess { Expression struct;  String field; }
    public Object visit(StructFieldAccess node, Object param) {
        if (node.getStruct() != null)
            node.getStruct().accept(this, CodeFunction.ADDRESS);
        StructType struct = (StructType) (node.getStruct());
        List<StructField> fields=struct.getDefinition().getFields();
        for (StructField field:fields ) {
            if(field.getName().equals(node.getField())){
                field.accept(this, CodeFunction.ADDRESS);
                out("load"+field.getType().getSuffix());
                return null;
            }
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
        return null;
    }

    //	class LiteralInt { String value; }
    public Object visit(LiteralInt node, Object param) {
        out("pushi "+node.getValue() );
        return null;
    }

    //	class LiteralFloat { String value; }
    public Object visit(LiteralFloat node, Object param) {
        out("pushf "+node.getValue() );
        return null;
    }

    //	class LiteralChar { String value; }
    public Object visit(LiteralChar node, Object param) {
        out("pushb "+node.getValue() );
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

    private int label=1; //To be used as a suffix.
    private int getLabel(){
        return this.label;
    }
    private void setLabel(){
        this.label+=1;
    }

    private PrintWriter writer;
    private String sourceFile;
}
