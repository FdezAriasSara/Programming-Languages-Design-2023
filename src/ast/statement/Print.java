/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import ast.expression.Expression;
import org.antlr.v4.runtime.*;

import visitor.*;

//	Print:statement -> expression:expression  variant:String

public class Print extends AbstractStatement {

	public Print(Expression expression, String variant) {
		this.expression = expression;
		this.variant = variant;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Print(Object expression, Object variant) {
		this.expression = (Expression) getAST(expression);
		this.variant = (variant instanceof Token) ? ((Token)variant).getText() : (String) variant;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, variant);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private String variant;

	public String toString() {
       return "{expression:" + getExpression() + ", variant:" + getVariant() + "}";
   }
}
