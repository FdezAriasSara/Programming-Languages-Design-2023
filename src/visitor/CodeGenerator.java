package visitor;
import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.type.*;
import ast.expression.*;

import java.io.*;

public class CodeGenerator extends DefaultVisitor{

    public static final int LINE = 1;
    private static final String OUTPUT_FILE = "generatedSource.txt";


    private static final int APPEND =2;
    private FileWriter printWriter;
    File sourceFile;
    Writer out ;

    public CodeGenerator(String filename ) throws IOException {
       sourceFile=new File(filename);
       out= new FileWriter(new File(sourceFile.getParent(), OUTPUT_FILE));

    }
    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {
        writeComment( "Código generado a partir de " + sourceFile.getName());
        super.visit(node, param); //I Pass the writer to the children
        return null;
    }

    //	class Variable { String name;  Type type; }
    public Object visit(Variable node, Object param) {
        writeCode(node.getName()+":"+node.getType(),LINE);
        super.visit(node, param);
        return null;
    }

    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {
         writeCode("var",APPEND);
         super.visit(node, param);


        return null;
    }

    //	class FunctionDefinition { String name;  List<Variable> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
    public Object visit(FunctionDefinition node, Object param) {

        super.visit(node, param);
        return null;
    }

    //	class StructDefinition { String name;  List<StructField> fields; }
    public Object visit(StructDefinition node, Object param) {
        writeCode("struct " +node.getName() +"{",LINE);
        super.visit(node, param);
        writeCode("}",LINE);
        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {

        writeCode("\t " +node.getName() +":",APPEND);
        super.visit(node, param);
        writeCode(";",LINE);
        return null;
    }

    //	class VoidType {  }
    public Object visit(VoidType node, Object param) {
        return null;
    }

    //	class IntType {  }
    public Object visit(IntType node, Object param) {
        writeCode( "int",APPEND);
        return null;
    }

    //	class FloatType {  }
    public Object visit(FloatType node, Object param) {
        writeCode( "float",APPEND);
        return null;
    }

    //	class CharType {  }
    public Object visit(CharType node, Object param) {
        writeCode( "char",APPEND);
        return null;
    }

    //	class ArrayType { List<LiteralInt> dimensions;  Type type; }
    public Object visit(ArrayType node, Object param) {
/*
        if (node.getDimensions() != null)

            for (LiteralInt child : node.getDimensions()){
                writeCode( "[",APPEND);
                child.accept(this, param);
                writeCode( "]",APPEND);
            }
*/

        if (node.getType() != null){
            node.getType().accept(this, param);
        }


        return null;
    }

    //	class StructType { String name; }
    public Object visit(StructType node, Object param) {
        writeCode(node.getName(),LINE);
        return null;
    }

    //	class Print { Expression expression;  String variant; }
    public Object visit(Print node, Object param) {
        writeCode(node.getVariant()+" ",APPEND);
        super.visit(node, param);
        writeCode(";",LINE);
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        writeCode("read ",APPEND);
         super.visit(node, param);
        writeCode("; ",LINE);

        return null;
    }

    //	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
    public Object visit(IfStatement node, Object param) {
        writeCode("if( ",APPEND);
        // super.visit(node, param);

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);
        writeCode("){ ",LINE);
        if (node.getBody() != null){
            for (Statement child : node.getBody())
                child.accept(this, param);
        }
        writeCode("} ",APPEND);
        if (node.getElseBody() != null) {
            writeCode("else{ ", LINE);
            for (Statement child : node.getElseBody())
                child.accept(this, param);
            writeCode("}", LINE);
        }
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

    //	class ArrayAccess { Expression array;  List<Expression> position; }
    public Object visit(ArrayAccess node, Object param) {

        // super.visit(node, param);

        if (node.getArray() != null)
            node.getArray().accept(this, param);
/*
        if (node.getPosition() != null)
            for (Expression child : node.getPosition())
                child.accept(this, param);
*/
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
    public void writeComment(String comment)  {
        try {
            out.write(String.format("/* %s */",comment));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void writeCode(String code,int variant)  {
        try {
            switch (variant){
                case LINE:
                    out.write(String.format(" %s \n",code));
                case APPEND:
                    out.write(code);

                    
            }
            out.write(String.format(" %s \n",code));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
