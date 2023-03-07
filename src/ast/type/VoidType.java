/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import visitor.*;

//	VoidType:type -> 

public class VoidType extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{VoidType}";
   }
}
