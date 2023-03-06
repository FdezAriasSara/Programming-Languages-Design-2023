/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definition;

import java.util.*;

import ast.expression.Variable;
import org.antlr.v4.runtime.*;

import visitor.*;

//	StructDefinition:definition -> name:String  fields:Variable*

public class StructDefinition extends AbstractDefinition {

	public StructDefinition(String name, List<Variable> fields) {
		this.name = name;
		this.fields = fields;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fields);
	}

	public StructDefinition(Object name, Object fields) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.fields = this.<Variable>getAstFromContexts(fields);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, fields);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Variable> getFields() {
		return fields;
	}
	public void setFields(List<Variable> fields) {
		this.fields = fields;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Variable> fields;

	public String toString() {
       return "{name:" + getName() + ", fields:" + getFields() + "}";
   }
}
