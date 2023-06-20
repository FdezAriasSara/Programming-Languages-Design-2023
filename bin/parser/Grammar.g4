grammar Grammar
	;
import Lexicon
	;
@parser :: header{
    import ast.*;
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.expression.*;

}

start returns[Program ast]
    : definitions+=definition* EOF {$ast=new Program($definitions);}
    ;

definition returns [Definition ast]
          :  IDENT '(' parameters')' ( ':' type)? '{' localDefs+=localDefinition* sts+=statement* '}'{$ast=new FunctionDefinition($IDENT, $parameters.list, ($ctx.type!=null ? $type.ast :new VoidType()), $localDefs, $sts);}
          | 'var'  IDENT ':' type ';' {$ast=new VarDefinition($IDENT,$type.ast); }
          | 'struct' IDENT '{'(fields+=structField ';')*'}'';' {$ast=new StructDefinition($IDENT, $fields);}
          ;


parameters returns [List<VarDefinition> list=new ArrayList<>(); ]
           : (params+=parameter (','params+=parameter)*)? {$list =new ArrayList($params);}
           ;

parameter  returns [VarDefinition ast]
           : IDENT ':' type {$ast=new VarDefinition($IDENT,$type.ast);}
            ;
localDefinition  returns [VarDefinition ast]
        :'var'  IDENT ':' type ';' {$ast=new VarDefinition($IDENT,$type.ast); }
        ;

structField returns [StructField ast]
        : IDENT ':' type {$ast=new StructField($IDENT,$type.ast);}
        ;

type  returns [Type ast]
    :'int' {$ast=new IntType();}
    |'float' {$ast=new FloatType();}
    |'char' {$ast=new CharType();}
    | '[' INT_CONSTANT']' type {$ast=new ArrayType($INT_CONSTANT,$type.ast );} // var a:[i+1] int; would not be allowed.
    | IDENT {$ast=new StructType($IDENT);}
    ;



statement returns [Statement ast]
        : left=expression '=' right=expression ';' {$ast=new Assignment($left.ast , $right.ast);}
        | 'if' '('condition=expression')' '{' ifBody+=statement* '}' ( 'else'  '{' elseBody+=statement* '}' )? {$ast=new IfStatement( $condition.ast, $ifBody,$elseBody );}
        | 'while' '('condition=expression')' '{' body+=statement* '}'{$ast=new While($condition.ast, $body);}
        | 'read' expression ';' {$ast=new Read($expression.ast);}
        | variant=('print' |'printsp'|'println' ) expression? ';'{$ast=new Print(($ctx.expression != null ? $expression.ast : new VoidType()),$variant);}
        | IDENT '('(arguments+=expression (','arguments+=expression)*)?')' ';'{$ast= new InvocationStatement($IDENT,$arguments);}
        | 'return' returnValue  {$ast=new Return($returnValue.ast);}
        ;

returnValue returns [Expression ast]
         : expression  ';'  {$ast= $expression.ast ;}
         | ';' // $ast will automatically be initialized to  `null`, AND context will not raise an exception!
         ; //I use an auxiliar rule to represent ? , since in THIS paritcular case I want NULL AND NOT Void type to be returned.

expression returns [Expression ast]
            : IDENT {$ast=new VariableReference($IDENT);} //for example: a=variableName;
            | INT_CONSTANT {$ast=new LiteralInt($INT_CONSTANT);}
            | REAL_CONSTANT{$ast=new LiteralFloat($REAL_CONSTANT);}
            | CHAR_CONSTANT{$ast=new LiteralChar($CHAR_CONSTANT);}
            | '('expression')' {$ast=$expression.ast;}//It has to have a higher priority
            | struct=expression'.' IDENT {$ast=new StructFieldAccess($struct.ast,$IDENT);}//struct field access.
            | array=expression '['expression']' {$ast=new ArrayAccess($array.ast,$expression.ast);}
            | '!' expression {$ast=new Not($expression.ast);}
            | '<'type'>' '('expression')' {$ast=new Cast($type.ast,$expression.ast);}
            | IDENT '('(arguments+=expression (','arguments+=expression)*)?')' {$ast=new Invocation($IDENT, $arguments);}//Invocations can appear as sentences or expressions.
            | left=expression operator=('*'|'/'|'%') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('+'|'-') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('>'|'<'|'>='|'<='|'=='|'!=') right=expression {$ast=new Comparison($left.ast, $operator, $right.ast);}
            | left=expression '&&' right=expression {$ast=new And($left.ast , $right.ast);}//And has more precedence than or.
            | left=expression '||' right=expression {$ast=new Or($left.ast, $right.ast);}
            ;





