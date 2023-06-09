/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;


import ast.*;
import main.*;
import visitor.*;
import ast.definition.*;
import ast.expression.*;
import ast.type.*;
import ast.statement.*;

import java.sql.Struct;
import java.util.*;


public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }


    //	class FunctionDefinition { String name;  List<VarDefinition> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {


        if (node.getParameters() != null) {
            for (VarDefinition child : node.getParameters()) {
                child.accept(this, param);
                predicado(hasSimpleType(child.getType()),"Los parámetros deben ser de tipo simple.",node);
            }
        }

        if (node.getReturnType() != null) {
            node.getReturnType().accept(this, param);
            predicado(hasSimpleType(node.getReturnType()),"El tipo de retorno debe ser de tipo simple.",node);
        }

        if (node.getLocalDefs() != null)
            for (VarDefinition child : node.getLocalDefs())
                child.accept(this, param);

        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, node);//IMPORTANT-> THE FUNCTION DEF NODE PASSES ITSELF SO ALL STAEMENTS CAN ACCESS IT.

        return null;
    }

    //	class Print { Expression expression;  String variant; }
    public Object visit(Print node, Object param) {
         super.visit(node, param);
        predicado(hasSimpleType(node.getExpression().getType()),node.getExpression()+" no es de tipo simple.",node);
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
         super.visit(node, param);
        predicado(hasSimpleType(node.getExpression().getType()),node.getExpression()+" no es de tipo simple.",node);
        predicado(node.getExpression().getLvalue(),node+" no es modificable.",node);
        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {
       super.visit(node, param);
        predicado(node.getCondition().getType() instanceof IntType, "La condición debe ser de tipo entero." ,node);
        return null;
    }

    //	class While { Expression condition;  List<Statement> body; }
    public Object visit(While node, Object param) {
          super.visit(node, param);
        predicado(node.getCondition().getType() instanceof IntType, "La condición debe ser de tipo entero." ,node);
        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        super.visit(node, param);
        predicado(node.getLeft().getLvalue(),node.getLeft()+" no es  modificable.",node);
        predicado(hasSimpleType(node.getLeft().getType()), "El valor asignado no es de tipo simple ("+node.getRight().getType()+")",node);
        predicado(node.getLeft().getType().equals(node.getRight().getType())," El valor a asignar debe ser del mismo tipo que la variable.",node);
        return null;
    }

    //	class InvocationStatement { String name;   List<Expression>  parameters; }
    public Object visit(InvocationStatement node, Object param) {
        super.visit(node, param);
        boolean sameSize=node.getParameters().size() == node.getDefinition().getParameters().size();
        predicado(sameSize,"El número de argumentos recibidos("+node.getDefinition().getParameters().size()+") no coincide con el esperado ("+node.getDefinition().getParameters().size()+")", node);
        if(sameSize) {
            predicado(checkArguments(node.getDefinition().getParameters(), node.getParameters()), "El tipo de los parámetros de la invoación no fueron los esperados.", node);
        }
        return null;
    }
    //	class Invocation { String name;   List<Expression> parameters; }
    public Object visit(Invocation node, Object param) {
     super.visit(node, param);
     boolean sameSize=node.getParameters().size() == node.getDefinition().getParameters().size();
     predicado(sameSize,"El número de argumentos recibidos("+node.getDefinition().getParameters().size()+") no coincide con el esperado ("+node.getDefinition().getParameters().size()+")", node);
       if(sameSize) {
           predicado(checkArguments(node.getDefinition().getParameters(), node.getParameters()), "El tipo de los parámetros de la invoación no fueron los esperados.", node);
       }
        predicado(!(node.getDefinition().getReturnType() instanceof VoidType),"La función es de tipo void",node);
        node.setType(node.getDefinition().getReturnType());
        return null;
    }



    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        super.visit(node, param);//Inherited attributes require PRE-ORDER.
        node.setFunctionDefinition((FunctionDefinition) param); // We recieve the definition node as a parameter.
        Type expected=node.getFunctionDefinition().getReturnType(),recieved;

        if(node.getExpression() == null){
//If no expression no information from the node start position will be displayed in the console msg.
            predicado(expected instanceof VoidType , "El return debe tener una expresión de tipo <"+expected+">." );
        }else {
            recieved=node.getExpression().getType();
            if(expected instanceof VoidType){
                predicado(false,"El return no debe tener expresión en funciones void.",node);
            }else {
                predicado(expected.equals(recieved), "El tipo de retorno  <" + recieved + ">  no fue el esperado <" + expected + ">.", node);
            }
        }

        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {
        super.visit(node, param);
        predicado(node.getLeft().getType().equals(node.getRight().getType()),"Las expresiones deben ser del mismo tipo en operaciones aritméticas.",node);
        predicado(!(node.getLeft().getType() instanceof VoidType),"No se pueden realizar operaciones aritméticas con expresiones de tipo void.",node);
        node.setType(node.getLeft().getType());
        return null;
    }

    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {
        super.visit(node, param);
        boolean isInt, isFloat,sameType=node.getRight().getType().equals(node.getLeft().getType());
        predicado(sameType,"Los elementos a comparar deben tener el mismo tipo.",node);
        isInt=node.getLeft().getType() instanceof IntType;
        isFloat=node.getLeft().getType() instanceof FloatType;
        predicado((isInt || isFloat) , "Los operadores de comparación solo pueden aplicarse a Enteros o Reales.", node);
        node.setType(new IntType());//TODO ? SE PUEDE "HARDCODEAR ASI?
        return null;
    }

    //	class And { Expression left;  Expression right; }
    public Object visit(And node, Object param) {

         super.visit(node, param);
        predicado(node.getLeft().getType()==node.getRight().getType(),"El operador And solo puede usarse con expresiones del mismo tipo .",node);
        predicado(node.getLeft().getType() instanceof IntType, "El operador And solo puede usarse con expresiones de tipo IntType.", node );
        node.setType(node.getLeft().getType());


        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {

        super.visit(node, param);//so the type of each expression is assigned prior to checking
        predicado(node.getLeft().getType().equals(node.getRight().getType()), "Las expresiones empleadas en un or deben ser del mismo tipo.", node);
        predicado(node.getLeft().getType() instanceof  IntType, "El operador Or solo puede emplearse con expresiones de tipo IntType.",node);
        node.setType(node.getLeft().getType());
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
        super.visit(node, param);
            Type typeToCast=node.getExpression().getType(), typeToCastTo=node.getType();
           predicado(!typeToCast.equals( typeToCastTo), "No se admiten conversiones al mismo tipo.",node);
           predicado(hasSimpleType(typeToCast) && hasSimpleType(typeToCastTo),"Error al intentar convertir "+typeToCast+" a "+typeToCastTo+". Las conversiones solo admiten tipos simples.",node);

        return null;
    }

    //	class ArrayAccess { Expression array;  Expression position; }
    public Object visit(ArrayAccess node, Object param) {

        super.visit(node, param);
        boolean isArrayType=node.getArray().getType() instanceof ArrayType;
        predicado(isArrayType,"El elemento accedido  debe ser de tipo array",node);
        predicado(node.getPosition().getType() instanceof IntType,"El índice de un acceso a array debe ser de tipo entero",node);
        if(isArrayType){
            //Asignamos al nodo de acceso a array el tipo de los elementos de la array accedida.
            ArrayType array=(ArrayType) (node.getArray().getType());
            node.setType(array.getType());
        }
        return null;
    }

    //	class StructFieldAccess { Expression struct;  String field; }
    public Object visit(StructFieldAccess node, Object param) {
        super.visit(node, param);
        boolean isStructType=node.getStruct().getType() instanceof  StructType;
        predicado(isStructType, node.getStruct()+" no es de tipo struct",node);
        if(isStructType) {
            //En la fase de identificación, se asigna a los tipos struct la definición del struct en sí.
            StructField field = findField((StructType) node.getStruct().getType(), node.getField());
            boolean foundField=field != null;
            predicado(foundField, "No existe el campo '" + node.getField() + "'.", node);
            if(foundField){
                node.setType(field.getType());
            }
        }
        return null;
    }

    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {
        node.setType(node.getDefinition().getType());
        return null;
    }

    public Object visit(LiteralFloat node, Object param) {
        node.setType(new FloatType());
        return null;
    }
    public Object visit(LiteralChar node, Object param) {
        node.setType(new CharType());
        return null;
    }
    public Object visit(LiteralInt node, Object param) {
        node.setType(new IntType());
        return null;
    }
    // Métodos auxiliares recomendados (opcionales) -------------


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
    // Métodos auxiliares recomendados (propios) -------------
    private boolean hasSimpleType(Type type){
        if(type instanceof ArrayType || type instanceof StructType){
            return false;
        }
       return true;
    }
    private ErrorManager errorManager;
    private boolean checkArguments(List<VarDefinition> parameters, List<Expression> parametersPassed) {
        VarDefinition currentExpected;
        Expression valueRecieved;
        for (int i = 0; i < parameters.size(); i++) {
            currentExpected=parameters.get(i);
            valueRecieved=parametersPassed.get(i);

            if(!currentExpected.getType().equals(valueRecieved.getType())){
                return false;
            }

        }
        return true;
    }


    private StructField findField(StructType struct, String fieldToFind){
        List<StructField> fields = struct.getDefinition().getFields();
        for (StructField field:fields
        ) {
            if(field.getName().equals(fieldToFind)){
                return field;
            }
        }
        return null;
    }
}
