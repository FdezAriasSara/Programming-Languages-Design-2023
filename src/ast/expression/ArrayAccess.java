/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	ArrayAccess:expression -> array:expression  position:expression*

public class ArrayAccess extends AbstractExpression {

	public ArrayAccess(Expression array, List<Expression> position) {
		this.array = array;
		this.position = position;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, position);
	}

	public ArrayAccess(Object array, Object position) {
		this.array = (Expression) getAST(array);
		this.position = this.<Expression>getAstFromContexts(position);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, position);
	}

	public Expression getArray() {
		return array;
	}
	public void setArray(Expression array) {
		this.array = array;
	}

	public List<Expression> getPosition() {
		return position;
	}
	public void setPosition(List<Expression> position) {
		this.position = position;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression array;
	private List<Expression> position;

	public String toString() {
       return "{array:" + getArray() + ", position:" + getPosition() + "}";
   }
}
