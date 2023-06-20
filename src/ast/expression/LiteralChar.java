/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import org.antlr.v4.runtime.*;

import visitor.*;

import java.util.regex.Pattern;

//	LiteralChar:expression -> value:Char

public class LiteralChar extends AbstractExpression {

	public LiteralChar(String value) {
		this.value =  getCharValue(value);
	}

	public LiteralChar(Object value) {

		this.value = (value instanceof Token) ? getCharValue(((Token)value).getText()) :getCharValue( (String) value);
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}
	public char getValue(){
		return this.value;
	}

	private char getCharValue(String value) {
		if(value.equals("'\\n'")){
			return '\n';

		}else if(value.length() == 3){
			//Si el lexema tiene la forma "típica" : '<char>'
			return value.charAt(1);
		}else{
			//En caso de que se pase el caracter usando el código ASCCI
			try{
				return (char) Integer.parseInt(value.substring(2, value.length()-1));
			}catch (Exception  e){
				System.out.println("No se pudo obtener el caracter equivalente a " + value);
			}
		}

		return '\u0000'; //caracter equivalente a null
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
