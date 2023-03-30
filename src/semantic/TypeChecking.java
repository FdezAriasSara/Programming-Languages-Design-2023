/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;


import ast.*;
import main.*;
import visitor.*;
import ast.*;
import ast.definition.*;
import ast.expression.*;
import ast.type.*;
import ast.statement.*;
import java.util.*;


public class TypeChecking extends DefaultVisitor {
    public IntType intType=new IntType();//singleton for type checking

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
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

    //	class Invocation { String name;  List<Variable> parameters; }
    public Object visit(Invocation node, Object param) {

        // super.visit(node, param);

        if (node.getParameters() != null)
            for (Variable child : node.getParameters())
                child.accept(this, param);

        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

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

         super.visit(node, param);
        predicado(node.getLeft().getType()==node.getRight().getType(),"El operador And solo puede usarse con expresiones del mismo tipo .",node);
        predicado(node.getLeft().getType()==intType, "El operador And solo puede usarse con expresiones de tipo IntType.", node );
        node.setType(node.getLeft().getType());

        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {

        super.visit(node, param);//so the type of each expression is assigned prior to checking
        predicado(node.getLeft()==node.getRight(), "Las expresiones empleadas en un or deben ser del mismo tipo.", node);
        predicado(node.getLeft().getType()==intType, "El operador Or solo puede emplearse con expresiones de tipo IntType.",node);

        return null;
    }

    //	class Not { Expression expression; }
    public Object visit(Not node, Object param) {

         super.visit(node, param);
         predicado(node.getExpression().getType() instanceof IntType,"El operador Not solo puede usarse con expresiones de tipo  IntType .",node);
         node.setType(node.getExpression().getType());



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


    // Métodos auxiliares recomendados (opcionales) -------------
    public boolean sameType(Type first, Type second){
        return first==second;
    }
    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private ErrorManager errorManager;
}
