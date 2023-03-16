/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import ast.definition.VarDefinition;
import org.antlr.v4.runtime.*;

import ast.type.*;


import visitor.*;

//	variable -> name:String  type:type

public class Variable extends AbstractAST  {
private VarDefinition definition;
	public Variable(String name, Type type) {
		this.name = name;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public Variable(Object name, Object type) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, type);
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	private String name;
	private Type type;

	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + "}";
   }

	//Fase de identificación
	public void setDefinition(VarDefinition definition){
		this.definition=definition;
	}
	public VarDefinition getDefinition(){
		return this.definition;
	}
}
