/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definition;

import java.util.*;
import org.antlr.v4.runtime.*;
import ast.*;
import ast.type.*;
import ast.statement.*;
import visitor.*;

//	FunctionDefinition:definition -> name:String  parameters:varDefinition*  returnType:type  localDefs:VarDefinition*  statements:statement*

public class FunctionDefinition extends AbstractDefinition {
	private boolean hasReturnStatement=false;
	public FunctionDefinition(String name, List<VarDefinition> parameters, Type returnType, List<VarDefinition> localDefs, List<Statement> statements) {
		this.name = name;
		this.parameters = parameters;
		this.returnType = returnType;
		this.localDefs = localDefs;
		this.statements = statements;
		setReturnStatement(statements.stream().anyMatch(stmt->stmt.hasReturnStatement()));


       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parameters, returnType, localDefs, statements);
	}

	public FunctionDefinition(Object name, Object parameters, Object returnType, Object localDefs, Object statements) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.parameters = this.<VarDefinition>getAstFromContexts(parameters);
		this.returnType = (Type) getAST(returnType);
		this.localDefs = this.<VarDefinition>getAstFromContexts(localDefs);
		this.statements = this.<Statement>getAstFromContexts(statements);
		setReturnStatement(this.statements.stream().anyMatch(stmt->stmt.hasReturnStatement()));
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, parameters, returnType, localDefs, statements);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean hasReturnStatement() {
		return hasReturnStatement;
	}
	public void setReturnStatement(boolean hasReturn) {this.hasReturnStatement=hasReturn;}

	public List<VarDefinition> getParameters() {
		return parameters;
	}
	public void setParameters(List<VarDefinition> parameters) {
		this.parameters = parameters;
	}

	public Type getReturnType() {
		return returnType;
	}
	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	public List<VarDefinition> getLocalDefs() {
		return localDefs;
	}
	public void setLocalDefs(List<VarDefinition> localDefs) {
		this.localDefs = localDefs;
	}

	public List<Statement> getStatements() {
		return statements;
	}
	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<VarDefinition> parameters;
	private Type returnType;
	private List<VarDefinition> localDefs;
	private List<Statement> statements;

	public String toString() {
       return "{name:" + getName() + ", parameters:" + getParameters() + ", returnType:" + getReturnType() + ", localDefs:" + getLocalDefs() + ", statements:" + getStatements() + "}";
   }


   //Code Selection
	public int getParameterSize(){
		int totalSize=0;
		for (VarDefinition parameter:parameters) {
			totalSize+=parameter.getType().getSize();
		}
		return totalSize;
	}

	//For local variables I simply access the offset of the last one and change it's sign.
}
