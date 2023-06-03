/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definition;

import java.util.*;


import org.antlr.v4.runtime.*;
import ast.*;
import visitor.*;

//	StructDefinition:definition -> name:String  fields:StructField*

public class StructDefinition extends AbstractDefinition {

	public StructDefinition(String name, List<StructField> fields) {
		this.name = name;
		this.fields = fields;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fields);
	}

	public StructDefinition(Object name, Object fields) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.fields = this.<StructField>getAstFromContexts(fields);

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

	public List<StructField> getFields() {
		return fields;
	}
	public void setFields(List<StructField> fields) {
		this.fields = fields;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<StructField> fields;

	public String toString() {
       return "{name:" + getName() + ", fields:" + getFields() + "}";
   }

//Añadido para la sub fase de reserva de memporia de generación de código
   private int direction;
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getDirection(){
		return direction;
	}
}
