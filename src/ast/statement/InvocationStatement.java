/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import ast.Variable;
import ast.expression.*;
import visitor.*;
import org.antlr.v4.runtime.*;
import java.util.List;

//	InvocationStatement:statement -> name:String  parameters:variable*

public class InvocationStatement extends AbstractStatement {

	public InvocationStatement(String name, List<Variable> parameters) {
		this.name = name;
		this.parameters = parameters;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parameters);
	}

	public InvocationStatement(Object name, Object parameters) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.parameters = this.<Variable>getAstFromContexts(parameters);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, parameters);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Variable> getParameters() {
		return parameters;
	}
	public void setParameters(List<Variable> parameters) {
		this.parameters = parameters;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Variable> parameters;

	public String toString() {
       return "{name:" + getName() + ", parameters:" + getParameters() + "}";
   }
}
