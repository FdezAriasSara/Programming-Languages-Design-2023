/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import ast.definition.FunctionDefinition;
import ast.type.Type;
import ast.type.VoidType;
import org.antlr.v4.runtime.*;
import ast.expression.*;
import visitor.*;

//	Return:statement -> expression:expression

public class Return extends AbstractStatement {

	public Return(Expression expression) {
		this.expression = expression;
		setReturnStatement(true);
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Return(Object expression) {
		this.expression = (Expression) getAST(expression);
		setReturnStatement(true);
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


	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;

	public String toString() {
       return "{expression:" + getExpression() + "}";
   }

   //Semantic Analysis
   private FunctionDefinition functionDefinition;
    public void setFunctionDefinition(FunctionDefinition param) {
		this.functionDefinition=param;
    }
	public FunctionDefinition getFunctionDefinition(){
		return this.functionDefinition;
	}
}
