/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import ast.StructField;
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
	public int getSize() {
		int totalSize=0;
		for (StructField field:definition.getFields()
			 ) {
			totalSize+=field.getType().getSize();
		}
		return totalSize ;
	}
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;

	public String toString() {
       return   getName() ;
   }
   //Fase de identificación
	private StructDefinition definition;
	public StructDefinition getDefinition(){
		return this.definition;
	}
	public void setDefinition(StructDefinition definition){
		this.definition=definition;
	}


}
