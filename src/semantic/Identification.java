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
        variables.reset();//todo:Teminate scope (is it necessary?
        structs.clear(); //Since structs are defined on a global scope

        return null;
    }


    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {

        VarDefinition definition=searchVarDefinition(node.getName(),node.getStart());
        if(definition!=null) {
            node.setDefinition(definition);
        }
        return null;
    }


    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {

        if(variables.getFromTop(node.getName())!=null){
            error("La variable '"+node.getName()+"' ya ha sido definida en este contexto.", node.getStart());
        } else{
            variables.put(node.getName(),node);
        }
        node.setGlobal(true);
        super.visit(node, param);//important not to delete. For example if the variable is of type structType, We need to assign the strucType with the definition too.

        return null;
    }

    //	class FunctionDefinition { String name;   List<VarDefinition> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {
        if(functions.get(node.getName())==null){
            functions.put(node.getName(), node);
        }else{
            //predicate not fulfilled.
            error("La función '"+node.getName()+"' ya ha sido definida." ,node.getStart());
        }
        variables.set();  //parameters will belong to local context of the function
        if (node.getParameters() != null)
            for (VarDefinition child : node.getParameters()){
                child.accept(this,param );
            }

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);

        if (node.getLocalDefs() != null)
            for (VarDefinition child : node.getLocalDefs())
                child.accept(this, param);

        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, param);
       variables.reset();
        return null;
        //local scopes are terminated the moment the curly braces are closed.



    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        if(structs.get(node.getName())!=null){
            error("La estructura '"+node.getName()+"' ya ha sido definida. ",node.getStart());
        }else {
            structs.put(node.getName(),node);
        }
        super.visit(node, param);

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
    //	class StructType { String name; }
    public Object visit(StructType node, Object param) {

        if(structs.get(node.getName())==null){
            error("La estructura '"+node.getName()+"' no ha sido definida. ",node.getStart());
        }else {
            node.setDefinition(structs.get(node.getName()));
        }
        return null;
    }
    //	class Invocation { String name;  List<Expression> parameters; }
    public Object visit(Invocation node, Object param) {
        super.visit(node, param);

        FunctionDefinition definition=functions.get(node.getName());
        if(definition==null){
            //predicate not fulfilled.
            error("La función  '"+node.getName()+"' no ha sido definida. ",node.getStart());
        }
        else{
            //WE LINK the invocation with its definition.
            node.setDefinition(definition);
        }

        return null;
    }

    //	class InvocationStatement { String name;   List<Expression> parameters;   }
    public Object visit(InvocationStatement node, Object param) {
        super.visit(node, param);
        FunctionDefinition definition=functions.get(node.getName());
        if(definition==null) {
            //predicate not fulfilled.
            error("El procedimiento '"+node.getName()+ "' no ha sido definido. ", node.getStart());
        } else{
            //WE LINK the invocation with its definition.
            node.setDefinition(definition);
        }

        return null;
    }





    /**
     * Auxiliar method to look for variable definitions to link to variable references and to variables.
     * @param name
     * @param start,position of the variable in case it's not found, the error message will include it.
     * @return
     */
    private VarDefinition searchVarDefinition(String name,Position start){
        VarDefinition definition=variables.getFromTop(name);//search in local context
        if(definition==null){
            definition=variables.getFromAny(name);//search in global
            if(definition==null){
                //arriving here means not finding a definition in any scope.
                error("La variable '"+name+"' no ha sido definida.", start);
                return null;
            }

        }
        return definition;
    }


    private void error(String msg) {
        error(msg, null);
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }


    private ErrorManager errorManager;
}
