/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;
import ast.*;
import ast.type.Type;

public abstract class AbstractExpression extends AbstractAST implements Expression {
   private boolean lValue=false;//The great majority of expressions are not modifiable.
    private Type type;
     public boolean getLvalue() {
        return this.lValue ;
    }
   public void setLvalue(boolean lvalue){
        this.lValue=lvalue;
    }
    public Type getType(){
         return this.type;
    }
    public void setType(Type type){
        this.type=type;
    }
}
