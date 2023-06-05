package visitor;
import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.type.*;
import ast.expression.*;

import java.io.*;

public class SourcecodeGenerator extends DefaultVisitor{

    public static final int LINE = 1;
    private static final String OUTPUT_FILE = "generatedSource.txt";

    private OutputStreamWriter writer;


    private static final int APPEND =2;

    File sourceFile;


    public SourcecodeGenerator(File file )  {

        sourceFile=file;
        try {
            this.writer=new OutputStreamWriter(new FileOutputStream(sourceFile));
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void dumpSource(AST ast){
        ast.accept(this,null);
        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(String text){
        try {
            this.writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {

        write("var");
        super.visit(node, param);
       write(";\n");


        return null;
    }

    //	class FunctionDefinition { String name;  List<VarDefinition> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {
        write("//Function definition \n");

        write(node.getName()+"(");
        if (node.getParameters() != null)
            for (VarDefinition child : node.getParameters()) {
                child.accept(this, param);

                write(",");
            }
        write("):");

        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);
        write("{\n");

        if (node.getLocalDefs() != null)
            for (VarDefinition child : node.getLocalDefs())
                child.accept(this, param);

        if (node.getStatements() != null)
            for (Statement child : node.getStatements()) {
                child.accept(this, param);
                write(";\n");
            }
        write("}\n");

        return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        write("struct "+node.getName()+"{\n");
        super.visit(node, param);
        write("}\n");
        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {

        write(node.getName());
        if (node.getType() != null)
            node.getType().accept(this, param);
        write(";\n");

        return null;
    }


    //	class IntType {  }
    public Object visit(IntType node, Object param) {
        write(" int");

        return null;
    }

    //	class FloatType {  }
    public Object visit(FloatType node, Object param) {
        write(" float");
        return null;
    }

    //	class CharType {  }
    public Object visit(CharType node, Object param) {
        write(" char");
        return null;

    }

    //	class ArrayType { String dimension;  Type type; }
    public Object visit(ArrayType node, Object param) {


        write(" ["+ node.getDimension()+"]");

       super.visit(node,param);

        return null;
    }

    //	class StructType { String name; }
    public Object visit(StructType node, Object param) {
        write(node.getName());
        return null;
    }

    //	class Print { Expression expression;  String variant; }
    public Object visit(Print node, Object param) {
        write(" print ");

         super.visit(node, param);
        write(";\n");

        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        write(" read ");

        super.visit(node, param);
        write(";\n");


        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {
        write("if(");

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);

        write("){\n");
        if (node.getBody() != null)
            for (Statement child : node.getBody())
                child.accept(this, param);
        write("}");
        if (node.getElseBody() != null) {
            write("else{\n");
            for (Statement child : node.getElseBody()) {
                child.accept(this, param);
            }
            write("}");
        }
        write("\n");
        return null;
    }

    //	class While { Expression condition;  List<Statement> body; }
    public Object visit(While node, Object param) {

        write("while(");
        if (node.getCondition() != null)
            node.getCondition().accept(this, param);
        write("){\n");
        if (node.getBody() != null)
            for (Statement child : node.getBody())
                child.accept(this, param);
        write("}\n");
        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {



        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        write("=");
        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Invocation { String name;  List<Expression> parameters; }
    public Object visit(Invocation node, Object param) {
        write(node.getName()+"(");
        super.visit(node, param);

        write(")");
        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        write("return ");
         super.visit(node, param);
        write(" ;\n");


        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {


        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        write(node.getOperator());
        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Comparison { Expression left;  String operator;  Expression right; }
    public Object visit(Comparison node, Object param) {



        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        write(node.getOperator());
        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class And { Expression left;  Expression right; }
    public Object visit(And node, Object param) {



        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        write(" && ");
        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Or { Expression left;  Expression right; }
    public Object visit(Or node, Object param) {



        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        write(" ||  ");
        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class Not { Expression expression; }
    public Object visit(Not node, Object param) {

        write(" !");
        super.visit(node, param);


        return null;
    }

    //	class Cast { Type type;  Expression expression; }
    public Object visit(Cast node, Object param) {


        write("<");
        if (node.getType() != null)
            node.getType().accept(this, param);
        write(">{");
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        write(")");
        return null;
    }

    //	class ArrayAccess.txt { Expression array;  Expression position; }
    public Object visit(ArrayAccess node, Object param) {

      super.visit(node, param);

        return null;
    }

    //	class StructFieldAccess.txt { Expression struct;  String field; }
    public Object visit(StructFieldAccess node, Object param) {

        super.visit(node, param);
        write("."+node.getField());
        return null;
    }

    //	class VariableReference { String name; }
    public Object visit(VariableReference node, Object param) {
        write(node.getName());
        return null;
    }

    //	class LiteralInt { String value; }
    public Object visit(LiteralInt node, Object param) {
        write(node.getValue());
        return null;
    }

    //	class LiteralFloat { String value; }
    public Object visit(LiteralFloat node, Object param) {
        write(node.getValue());
        return null;
    }

    //	class LiteralChar { String value; }
    public Object visit(LiteralChar node, Object param) {
        write(node.getValue());
        return null;
    }
}
