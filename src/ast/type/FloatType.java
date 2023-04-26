/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import visitor.*;

//	FloatType:type -> 

public class FloatType extends AbstractType {

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FloatType){
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
		return 4;
	}

	@Override
	public char getSuffix() {
		return 'f';
	}

	public String toString() {
       return "{FloatType}";
   }
}
