/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;
import ast.*;
import ast.definition.*;
import ast.expression.*;
import ast.type.*;
import ast.statement.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinitions(), param);
		return null;
	}

	//	class Variable { String name;  Type type; }
	public Object visit(Variable node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class VarDefinition { Type type;  String name; }
	public Object visit(VarDefinition node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class FunctionDefinition { String name;  List<Variable> parameters;  Type returnType;  List<VarDefinition> localDefs;  List<Statement> statements; }
	public Object visit(FunctionDefinition node, Object param) {
		visitChildren(node.getParameters(), param);
		if (node.getReturnType() != null)
			node.getReturnType().accept(this, param);
		visitChildren(node.getLocalDefs(), param);
		visitChildren(node.getStatements(), param);
		return null;
	}

	//	class StructDefinition { String name;  List<StructField> fields; }
	public Object visit(StructDefinition node, Object param) {
		visitChildren(node.getFields(), param);
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
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

	//	class ArrayType { List<LiteralInt> dimensions;  Type type; }
	public Object visit(ArrayType node, Object param) {
		visitChildren(node.getDimensions(), param);
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
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class IfStatement { Expression condition;  List<Statement> body;  List<Statement> elseBody; }
	public Object visit(IfStatement node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getBody(), param);
		visitChildren(node.getElseBody(), param);
		return null;
	}

	//	class While { Expression condition;  List<Statement> body; }
	public Object visit(While node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getBody(), param);
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Invocation { String name;  List<Variable> parameters; }
	public Object visit(Invocation node, Object param) {
		visitChildren(node.getParameters(), param);
		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Comparison { Expression left;  String operator;  Expression right; }
	public Object visit(Comparison node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class And { Expression left;  Expression right; }
	public Object visit(And node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Or { Expression left;  Expression right; }
	public Object visit(Or node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Not { Expression expression; }
	public Object visit(Not node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Cast { Type type;  Expression expression; }
	public Object visit(Cast node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ArrayAccess { Expression array;  List<Expression> position; }
	public Object visit(ArrayAccess node, Object param) {
		if (node.getArray() != null)
			node.getArray().accept(this, param);
		visitChildren(node.getPosition(), param);
		return null;
	}

	//	class StructFieldAccess { Expression struct;  String field; }
	public Object visit(StructFieldAccess node, Object param) {
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

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
