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

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }
    Map<String,FunctionDefinition> functions=new HashMap<>();
    Map<String,StructDefinition> structs=new HashMap<>();
    ContextMap<String, VarDefinition> variables= new ContextMap<>();
    Map<String,StructField> fields=new HashMap<>();
    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {
         variables.set();//Initialize global scope.
         super.visit(node, param);
        variables.reset();//Teminate scope (is it necessary?


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
        if(functions.get(node.getName())==null){
            functions.put(node.getName(), node);
        }else{
            //predicate not fulfilled.
            error("La función ' "+node.getName()+" 'ya ha sido declarada." ,node.getStart());
        }


        if (node.getParameters() != null)
            for (Variable child : node.getParameters())
                child.accept(this, param);

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);

        if (node.getLocalDefs() != null){
            variables.set();  //When the curly braces opens, a new scope is created.
            for (VarDefinition child : node.getLocalDefs())
                child.accept(this, param);

        }


        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, param);

       variables.reset();
        return null;
        //Scopes are terminated the moment the curly braces are closed.



    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        if(structs.get(node.getName())==null) {
            structs.put(node.getName(),node);
        }else{
            error("La estructura '"+node.getName()+"' ya ha sido definida. ",node.getStart());
        }
        super.visit(node, param);
        structs.clear();

        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {
        if(fields.get(node.getName())==null){
            fields.put(node.getName(),node);
        }else{
            error("El campo  '"+node.getName()+"' ya ha sido definido. ",node.getStart());
        }
        super.visit(node, param);
        return null;
    }

    //	class Invocation { String name;  List<Variable> parameters; }
    public Object visit(Invocation node, Object param) {

        FunctionDefinition definition=functions.get(node.getName());
        if(definition==null){
            //predicate not fulfilled.
            error("La función no ha sido declarada. ",node.getStart());
        }
        else{
            //WE LINK the invocation with its definition.
            node.setDefinition(definition);
        }
        super.visit(node, param);

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

    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {
        return null;
    }


    private void error(String msg) {
        error(msg, null);
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }


    private ErrorManager errorManager;
}
