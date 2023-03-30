/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import ast.type.Type;
import ast.type.VoidType;
import org.antlr.v4.runtime.*;
import ast.expression.*;
import visitor.*;

//	Return:statement -> expression:expression

public class Return extends AbstractStatement {

	public Return(Expression expression) {
		this.expression = expression;
		setReturnTypeOfExpression(expression);//para evitar nullPointer exception si la sentencia no tiene expresión de retorno.

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Return(Object expression) {
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/**
	 * Redefino este método , porque cuando una función es de tipo void, esta no tiene expresión en su sentencia de retorno.
	 * Esto da lugar , a que , al crear el nodo AST el parámetro pasado al constructor de Return sea null.
	 * Si intentamos asignar a la sentencia el tipo de la expresión de retorno, en este caso , mediante null.getType()
	 * obtendremos un error.
	 *
	 * @param type
	 */

	public void setReturnTypeOfExpression(Expression expression) {
		if(expression!=null){
			setReturnType(expression.getType());
		}else{
			setReturnType(new VoidType());
		}

	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;

	public String toString() {
       return "{expression:" + getExpression() + "}";
   }
}
