/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;
import ast.expression.*;
//	While:statement -> condition:expression  body:statement*

public class While extends AbstractStatement {

	public While(Expression condition, List<Statement> body) {
		this.condition = condition;
		this.body = body;
		setReturnStatement(this.body.stream().anyMatch(stmt-> stmt.hasReturnStatement()));
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, body);
	}

	public While(Object condition, Object body) {
		this.condition = (Expression) getAST(condition);
		this.body = this.<Statement>getAstFromContexts(body);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, body);
		setReturnStatement(this.body.stream().anyMatch(stmt-> stmt.hasReturnStatement()));
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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Statement> body;

	public String toString() {
       return "{condition:" + getCondition() + ", body:" + getBody() + "}";
   }
}
