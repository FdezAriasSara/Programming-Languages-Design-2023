/**
 * @generated VGen (for ANTLR) 1.7.2
 */
package ast.expression;

import org.antlr.v4.runtime.*;

import visitor.*;

//	LiteralFloat:expression -> value:double

public class LiteralFloat extends AbstractExpression {

	public LiteralFloat(double value) {
		this.value = value;
	}

	public LiteralFloat(Object value) {
		this.value = (value instanceof Token) ? Double.parseDouble(((Token)value).getText()) : (Double) value;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(value);
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private double value;

	public String toString() {
		return  String.valueOf(getValue()) ;
	}
}