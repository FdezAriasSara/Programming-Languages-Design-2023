/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import ast.definition.VarDefinition;
import org.antlr.v4.runtime.*;

import visitor.*;

//	VariableReference:expression -> name:String

public class VariableReference extends AbstractExpression {

	public VariableReference(String name) {
		this.name = name;
	}

	public VariableReference(Object name) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;

	public String toString() {
       return "{name:" + getName() + "}";
   }

	public VarDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(VarDefinition definition) {
		this.definition = definition;

	}

	private VarDefinition definition;
}
