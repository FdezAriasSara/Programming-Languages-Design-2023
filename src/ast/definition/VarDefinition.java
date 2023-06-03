/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definition;

import org.antlr.v4.runtime.*;
import ast.type.*;
import visitor.*;

//	VarDefinition:definition -> type:type  name:String

public class VarDefinition extends AbstractDefinition {

	public VarDefinition( String name,Type type) {
		this.type = type;
		this.name = name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public VarDefinition( Object name, Object type) {
		this.type = (Type) getAST(type);
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, name);
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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

	private Type type;
	private String name;

	public String toString() {
       return "{type:" + getType() + ", name:" + getName() + "}";
   }


   //Memory Allocation
	private int direction;
	public int getDirection(){
		return this.direction;
	}
	public void setDirection(int direction){
		this.direction = direction;
	}

	//Añadido en generación de código
	private boolean	 isGlobal;
	public boolean isGlobal(){return this.isGlobal;}
	public void setGlobal(boolean isGlobal){  this.isGlobal=isGlobal;}
}
