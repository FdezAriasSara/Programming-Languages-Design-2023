/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import ast.expression.*;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.expression.CharValue;
import ast.statement.*;
import ast.type.*;



public interface Visitor {
    public Object visit(Program node, Object param);
    public Object visit(VarDefinition node, Object param);
    public Object visit(FunctionDefinition node, Object param);
    public Object visit(StructDefinition node, Object param);
    public Object visit(IntType node, Object param);
    public Object visit(FloatType node, Object param);
    public Object visit(CharType node, Object param);
    public Object visit(ArrayType node, Object param);
    public Object visit(StructType node, Object param);
    public Object visit(Print node, Object param);
    public Object visit(Read node, Object param);
    public Object visit(IfStatement node, Object param);
    public Object visit(While node, Object param);
    public Object visit(Assignment node, Object param);
    public Object visit(Invocation node, Object param);
    public Object visit(Return node, Object param);
    public Object visit(ArithmeticExpression node, Object param);
    public Object visit(Comparison node, Object param);
    public Object visit(And node, Object param);
    public Object visit(Or node, Object param);
    public Object visit(Not node, Object param);
    public Object visit(Cast node, Object param);
    public Object visit(ArrayAccess node, Object param);
    public Object visit(StructFieldAccess node, Object param);
    public Object visit(Variable node, Object param);
    public Object visit(IntValue node, Object param);
    public Object visit(FloatValue node, Object param);
    public Object visit(CharValue node, Object param);
}