/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import java.util.*;

import ast.expression.LiteralInt;
import org.antlr.v4.runtime.*;

import visitor.*;


/**
 * @generated VGen (for ANTLR) 1.7.2
 */

//	ArrayType:type -> dimension:String  type:type

public class ArrayType extends AbstractType {

	public ArrayType(String dimension, Type type) {
		this.dimension = dimension;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public ArrayType(Object dimension, Object type) {
		this.dimension = (dimension instanceof Token) ? ((Token)dimension).getText() : (String) dimension;
		this.type = (Type) getAST(type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(dimension, type);
	}

	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String dimension;
	private Type type;

	public String toString() {
		return "{dimension:" + getDimension() + ", type:" + getType() + "}";
	}


	//memory allocation

	@Override
	public int getSize() {
		return  type.getSize()*Integer.parseInt(dimension);
	}
}
