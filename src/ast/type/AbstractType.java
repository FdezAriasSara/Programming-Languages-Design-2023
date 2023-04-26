/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import ast.AbstractAST;

public abstract class AbstractType extends AbstractAST implements Type {


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public char getSuffix() {
        throw new RuntimeException("The compiler tried to access the suffix of a complex type.");
    }
}
