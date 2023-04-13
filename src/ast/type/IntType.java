/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import visitor.*;

//	IntType:type -> 

public class IntType extends AbstractType {
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IntType){
			return true;
		}
		return super.equals(obj);
	}
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	@Override
	public int getSize() {
		return 2;
	}

	public String toString() {
       return "{IntType}";
   }
}
