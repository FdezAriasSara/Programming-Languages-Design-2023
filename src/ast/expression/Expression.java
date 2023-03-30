/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expression;
import ast.*;
import ast.type.Type;

public interface Expression extends AST {
    public void setLvalue(boolean isLvalue);
   public boolean getLvalue();
   public void setType(Type type);
   public Type getType();
}
