/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import ast.definition.Definition;
import ast.definition.StructDefinition;
import org.antlr.v4.runtime.*;

import visitor.*;

//	StructType:type -> name:String

public class StructType extends AbstractType {

	public StructType(String name) {
		this.name = name;
	}
	public StructType(Object name) {
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


}
