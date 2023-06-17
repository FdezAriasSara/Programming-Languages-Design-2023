/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import org.antlr.v4.runtime.*;

import visitor.*;

//	LiteralChar:expression -> value:Char

public class LiteralChar extends AbstractExpression {

	public LiteralChar(String value) {
		this.value =  value.replace("'","").charAt(0);
	}

	public LiteralChar(Object value) {
		String text;
		if(value instanceof Token){
			 text=((Token) value).getText().replace("'","");

		}else{
			text=((String)value).replace("'","") ;

		}
		this.value=text.charAt(0);


       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private char value;


	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
