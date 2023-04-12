/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;

import org.antlr.v4.runtime.*;

import visitor.*;

//	StructFieldAccess :expression -> struct:expression  field:String

public class StructFieldAccess extends AbstractExpression {

	public StructFieldAccess(Expression struct, String field) {
		this.struct = struct;
		this.field = field;
		setLvalue(true);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct);
	}

	public StructFieldAccess(Object struct, Object field) {
		this.struct = (Expression) getAST(struct);
		this.field = (field instanceof Token) ? ((Token)field).getText() : (String) field;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct, field);
	}

	public Expression getStruct() {
		return struct;
	}
	public void setStruct(Expression struct) {
		this.struct = struct;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression struct;
	private String field;

	public String toString() {
       return "{struct:" + getStruct() + ", field:" + getField() + "}";
   }
}
