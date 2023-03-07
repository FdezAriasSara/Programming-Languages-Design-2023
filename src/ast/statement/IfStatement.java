/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import java.util.*;

import ast.expression.Expression;
import org.antlr.v4.runtime.*;

import visitor.*;

//	IfStatement:statement -> condition:expression  body:statement*  elseBody:statement*

public class IfStatement extends AbstractStatement {

	public IfStatement(Expression condition, List<Statement> body, List<Statement> elseBody) {
		this.condition = condition;
		this.body = body;
		this.elseBody = elseBody;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, body, elseBody);
	}

	public IfStatement(Object condition, Object body, Object elseBody) {
		this.condition = (Expression) getAST(condition);
		this.body = this.<Statement>getAstFromContexts(body);
		this.elseBody = this.<Statement>getAstFromContexts(elseBody);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, body, elseBody);
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Statement> getBody() {
		return body;
	}
	public void setBody(List<Statement> body) {
		this.body = body;
	}

	public List<Statement> getElseBody() {
		return elseBody;
	}
	public void setElseBody(List<Statement> elseBody) {
		this.elseBody = elseBody;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Statement> body;
	private List<Statement> elseBody;

	public String toString() {
       return "{condition:" + getCondition() + ", body:" + getBody() + ", elseBody:" + getElseBody() + "}";
   }
}
