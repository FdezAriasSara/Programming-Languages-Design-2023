/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import ast.expression.ArrayAccess;
import visitor.*;
import ast.definition.*;
import ast.statement.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {


    private int globalDir=0;


    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {
        super.visit(node, param);
        node.setDirection(globalDir);
        globalDir+=node.getType().getSize();
        return null;
    }

    //	class FunctionDefinition { String name;  List<Variable> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {


        if (node.getParameters() != null)
            for (Variable child : node.getParameters())
                child.accept(this, param);

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);

        if (node.getLocalDefs() != null) {
            int lastLocalVariable=0;
            for (VarDefinition child : node.getLocalDefs()) {
                 child.accept(this, param);
                 lastLocalVariable+= child.getType().getSize(); //we also need to sum the size of the current variable.
                 child.setDirection(lastLocalVariable);

            }
        }

        if (node.getStatements() != null)
            for (Statement child : node.getStatements())
                child.accept(this, param);

        return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {

        int sizeInMemory=0;
        if (node.getFields() != null) {
            for (StructField child : node.getFields()) {

                child.accept(this, sizeInMemory);
                sizeInMemory+= child.getType().getSize();
            }
        }
        node.setDirection(  sizeInMemory);//we need to reserve space for its fields.
        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {
        node.setDirection((Integer) param);
        return null;
    }


}