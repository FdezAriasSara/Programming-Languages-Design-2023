/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;
import ast. *;
import ast.type.Type;

public abstract class AbstractStatement extends AbstractAST implements Statement {
    private boolean hasReturn=false;
    @Override
    public boolean hasReturnStatement() {
        return hasReturn;
    }

    @Override
    public void setReturnStatement(boolean hasReturn) {
        this.hasReturn=hasReturn;
    }
}
