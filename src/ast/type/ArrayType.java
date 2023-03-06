/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import java.util.*;

import ast.expression.IntValue;

import visitor.*;

//	ArrayType:type -> dimensions:IntValue*  type:type

public class ArrayType extends AbstractType {

	public ArrayType(List<IntValue> dimensions, Type type) {
		this.dimensions = dimensions;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(dimensions, type);
	}

	public ArrayType(Object dimensions, Object type) {
		this.dimensions = this.<IntValue>getAstFromContexts(dimensions);
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(dimensions, type);
	}

	public List<IntValue> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<IntValue> dimensions) {
		this.dimensions = dimensions;
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

	private List<IntValue> dimensions;
	private Type type;

	public String toString() {
       return "{dimensions:" + getDimensions() + ", type:" + getType() + "}";
   }
}
