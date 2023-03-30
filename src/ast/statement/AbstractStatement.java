/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;
import ast. *;
import ast.type.Type;

public abstract class AbstractStatement extends AbstractAST implements Statement {
    private Type returnType;
    public void setReturnType(Type type){
        this.returnType=type;
    }
    public Type getReturnType(){
        return this.returnType;
    }
}
