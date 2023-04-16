/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.*;
import ast.definition.*;
import ast.expression.*;
import ast.type.*;
import ast.statement.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

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

        super.visit(node, param);
        node.setDir(node.getType().getSize());


        return null;
    }

    //	class FunctionDefinition { String name;  List<Variable> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {

         super.visit(node, param);

        if (node.getParameters() != null) {
            for (Variable child : node.getParameters()) {
                child.accept(this, param);

            }
        }

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);

        if (node.getLocalDefs() != null) {
            int lastLocalVariable=0;
            for (VarDefinition child : node.getLocalDefs()) {
                 child.accept(this, param);
                 lastLocalVariable+= child.getType().getSize(); //we also need to sum the size of the current variable.
                 child.setDir(lastLocalVariable);

            }
        }

        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, param);

        return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {

        // super.visit(node, param);

        if (node.getFields() != null) {
            int sizeInMemory=0;
            for (StructField child : node.getFields()) {
                child.accept(this, param);
               sizeInMemory+= child.getType().getSize();
            }
            //node.setDir(node);//we need to reserve space for its fields.
        }

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

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

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

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

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

        // super.visit(node, param);

        if (node.getParameters() != null)
            for (Expression child : node.getParameters())
                child.accept(this, param);

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

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class And { Expression left;  Expression right; }
    public Object visit(And node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Not { Expression expression; }
    public Object visit(Not node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        return null;
    }

    //	class Cast { Type type;  Expression expression; }
    public Object visit(Cast node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        return null;
    }

    //	class ArrayAccess { Expression array;  Expression position; }
    public Object visit(ArrayAccess node, Object param) {

        // super.visit(node, param);

        if (node.getArray() != null)
            node.getArray().accept(this, param);

        if (node.getPosition() != null)
            node.getPosition().accept(this, param);

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
        return null;
    }

    //	class LiteralInt { String value; }
    public Object visit(LiteralInt node, Object param) {
        return null;
    }

    //	class LiteralFloat { String value; }
    public Object visit(LiteralFloat node, Object param) {
        return null;
    }

    //	class LiteralChar { String value; }
    public Object visit(LiteralChar node, Object param) {
        return null;
    }
}