/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	ArrayAccess:expression -> name:String  position:expression*

public class ArrayAccess extends AbstractExpression {

	public ArrayAccess(String name, List<Expression> position) {
		this.name = name;
		this.position = position;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(position);
	}

	public ArrayAccess(Object name, Object position) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.position = this.<Expression>getAstFromContexts(position);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, position);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	private String name;
	private List<Expression> position;

	public String toString() {
       return "{name:" + getName() + ", position:" + getPosition() + "}";
   }
}
