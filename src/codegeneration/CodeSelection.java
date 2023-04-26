/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.HashMap;
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
        ADDRESS, VALUE
    }
    private Map<String, String> instruction=new HashMap<String,String>();
    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
        instruction.put("+","add");
        instruction.put("-","sub");
        instruction.put("*","mul");
        instruction.put("/","div");

    }
    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {

        // super.visit(node, param);

        if (node.getDefinitions() != null)
            for (Definition child : node.getDefinitions())
                child.accept(this, param);

        return null;
    }

    //	class Variable { String name;  Type type; }
    public Object visit(Variable node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        return null;
    }

    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        return null;
    }

    //	class FunctionDefinition { String name;  List<Variable> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {

        // super.visit(node, param);

        if (node.getParameters() != null)
            for (Variable child : node.getParameters())
                child.accept(this, param);

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);

        if (node.getLocalDefs() != null)
            for (VarDefinition child : node.getLocalDefs())
                child.accept(this, param);

        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, param);

        return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {

        // super.visit(node, param);

        if (node.getFields() != null)
            for (StructField child : node.getFields())
                child.accept(this, param);

        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        return null;
    }

    //	class VoidType {  }
    public Object visit(VoidType node, Object param) {
        return null;
    }

    //	class IntType {  }
    public Object visit(IntType node, Object param) {
        return null;
    }

    //	class FloatType {  }
    public Object visit(FloatType node, Object param) {
        return null;
    }

    //	class CharType {  }
    public Object visit(CharType node, Object param) {
        return null;
    }

    //	class ArrayType { String dimension;  Type type; }
    public Object visit(ArrayType node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        return null;
    }

    //	class StructType { String name; }
    public Object visit(StructType node, Object param) {
        return null;
    }

    //	class Print { Expression expression;  String variant; }
    public Object visit(Print node, Object param) {

            node.getExpression().accept(this, CodeFunction.VALUE);
            //We need the value of the expression to print on top of the stack
            out("out",node.getExpression().getType());

        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {

        // super.visit(node, param);

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);

        if (node.getBody() != null)
            for (Statement child : node.getBody())
                child.accept(this, param);

        if (node.getElseBody() != null)
            for (Statement child : node.getElseBody())
                child.accept(this, param);

        return null;
    }

    //	class While { Expression condition;  List<Statement> body; }
    public Object visit(While node, Object param) {

        // super.visit(node, param);

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);

        if (node.getBody() != null)
            for (Statement child : node.getBody())
                child.accept(this, param);

        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        node.getLeft().accept(this, CodeFunction.ADDRESS);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("store ",node.getRight().getType());

        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

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

        // super.visit(node, param);

        if (node.getParameters() != null)
            for (Expression child : node.getParameters())
                child.accept(this, param);

        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {
            node.getLeft().accept(this, CodeFunction.VALUE);
            node.getRight().accept(this, CodeFunction.VALUE);
            //Notice that type errors sould have already been detected prior to this phase.
            //therefore, we can assume both have the same type and it should be simple.
            String instruction=getArithmeticInstruction(node.getOperator());
            //Also , the arithExp node was set to the type of the operands in the TypeChecking.
            out(instruction,node.getType());
        return null;
    }



    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {

        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        String instruction=getComparissonInstruction(node.getOperator());
        out(instruction,node.getType());
        return null;
    }


    //	class And { Expression left;  Expression right; }
    public Object visit(And node, Object param) {

        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("and");
        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {

        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("or");

        return null;
    }

    //	class Not { Expression expression; }
    public Object visit(Not node, Object param) {
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("not");
        return null;
    }

    //	class Cast { Type type;  Expression expression; }
    public Object visit(Cast node, Object param) {
        out(node.getType().getSuffix()+"2"+node.getExpression().getType().getSuffix());
        return null;
    }

    //	class ArrayAccess { Expression array;  Expression position; }
    public Object visit(ArrayAccess node, Object param) {

        node.getArray().accept(this, CodeFunction.ADDRESS);//We push the address the array is stored at
        node.getPosition().accept(this,CodeFunction.VALUE);//We push the index
        //the following will always be applied to ints.
        out("pushi " +node.getType().getSize() ); //We push the size of the element
        out("muli" );//we multiply index*sizeOfElements to get the offset of the element within the array
        out("addi" );//we add the offset to the first directon of the ones reserved for the array, in order to get the exact position

        return null;
    }

    //	class StructFieldAccess { Expression struct;  String field; }
    public Object visit(StructFieldAccess node, Object param) {

        // super.visit(node, param);

        if (node.getStruct() != null)
            node.getStruct().accept(this, param);

        return null;
    }

    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {
        node.getDefinition().accept(this, CodeFunction.ADDRESS);
        out("loadi");
        return null;
    }

    //	class LiteralInt { String value; }
    public Object visit(LiteralInt node, Object param) {
        out("pushi "+node.getValue());
        return null;
    }

    //	class LiteralFloat { String value; }
    public Object visit(LiteralFloat node, Object param) {
        out("pushf "+node.getValue());
        return null;
    }

    //	class LiteralChar { String value; }
    public Object visit(LiteralChar node, Object param) {
        out("pushb "+node.getValue());
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
    private String getArithmeticInstruction(String operator) {
        switch (operator){
            case "+":
                return "add";
            case "-":
                return "sub";
            case "*":
                return "mul";
            case "/":
                return "div";
            default:
                throw new RuntimeException("The operator was not within the ones expected");
                //It should never reach this line because this would be a grammar error that should have been detected prior to this phase.
        }
    }

    private String getComparissonInstruction(String operator) {
        //('>'|'<'|'>='|'<='|'=='|'!=')
        switch (operator){
            case ">":
                return "gt";
            case ">=":
                return "ge";
            case "<":
                return "lt";
            case "<=":
                return "le";
            case "==":
                return "eq";
            case "!=":
                return "ne";
            default:
                throw new RuntimeException("The operator was not within the ones expected");
                //It should never reach this line because this would be a grammar error that should have been detected prior to this phase.
        }
    }

    private PrintWriter writer;
    private String sourceFile;
}
