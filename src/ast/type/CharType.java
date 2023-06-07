/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import visitor.*;

//	CharType:type -> 

public class CharType extends AbstractType {
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CharType){
			return true;
		}
		return super.equals(obj);
	}

	@Override
	public int getSize() {
		return 1;
	}
	@Override
	public char getSuffix() {
		return 'b';
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "char";
   }
}
