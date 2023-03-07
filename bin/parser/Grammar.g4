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


parameters returns [List<Variable> list=new ArrayList<>(); ]
           : (params+=parameter (','params+=parameter)*)? {$list =new ArrayList($params);}
           ;

parameter  returns [Variable ast]
           : IDENT ':' type {$ast=new Variable($IDENT,$type.ast);}
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
    | ('['dimensions+=dimension']')+ type {$ast=new ArrayType($dimensions,$type.ast );} // var a:[i+1] int; would not be allowed.
    | IDENT {$ast=new StructType($IDENT);}
    ;

dimension returns [LiteralInt ast]
            : INT_CONSTANT{$ast=new LiteralInt($INT_CONSTANT);}
            ;
statement returns [Statement ast]
        : expression '=' expression ';' {$ast=new Assignment($expression.ast, $expression.ast);}
        | 'if' '('condition=expression')' '{' ifBody+=statement* '}' ( 'else'  '{' elseBody+=statement* '}' )? {$ast=new IfStatement( $condition.ast, $ifBody,$elseBody );}
        | 'while' '('condition=expression')' '{' body+=statement* '}'{$ast=new While($condition.ast, $body);}
        | 'read' expression ';' {$ast=new Read($expression.ast);}
        | variant=('print' |'printsp'|'println' ) expression? ';'{$ast=new Print(($ctx.expression != null ? $expression.ast : new VoidType()),$variant);}
        | invocation ';'{$ast= $invocation.ast;}
        | 'return' returnValue  {$ast=new Return($returnValue.ast);}
        ;

returnValue returns [Expression ast]
         : expression  ';'  {$ast= $expression.ast ;}
         | ';'
         ;

invocation returns [Invocation ast]
        :IDENT '('(arguments+=expression (','arguments+=expression)*)?')' {$ast=new Invocation($IDENT, $arguments);}
        ; //Arguments are passed BY VALUE.

expression returns [Expression ast]
            : IDENT {$ast=new VariableReference($IDENT);} //for example: a=variableName;
            | INT_CONSTANT {$ast=new LiteralInt($INT_CONSTANT);}
            | REAL_CONSTANT{$ast=new LiteralFloat($REAL_CONSTANT);}
            | CHAR_CONSTANT{$ast=new LiteralChar($CHAR_CONSTANT);}
             | '('expression')' {$ast=$expression.ast;}//It has to have a higher priority
            | left=expression operator=('*'|'/') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('+'|'-') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('>'|'<'|'>='|'<='|'=='|'!=') right=expression {$ast=new Comparison($left.ast, $operator, $right.ast);}
            | left=expression '&&' right=expression {$ast=new And($left.ast , $right.ast);}
            | left=expression '||' right=expression {$ast=new Or($left.ast, $right.ast);}
            | '!' expression {$ast=new Not($expression.ast);}
            | '<'type'>' '('expression')' {$ast=new Cast($type.ast,$expression.ast);}
            | array=expression ('['positionCoord+=expression']')+ {$ast=new ArrayAccess($array.ast,$positionCoord);}
            | struct=expression'.' IDENT {$ast=new StructFieldAccess($struct.ast,$IDENT);}//struct field access.
            | invocation {$ast=$invocation.ast;}//Invocations can appear as sentences or expressions.

            ;






/*
Decisions taken:
**VGEN strategy***
Since I plan on using VGEN tool to generate the ast classes, I will:
-> Specify optionality on the CHILD rule(detailed explanation below)
-> Specify repetition on the PARENT rule
-> Use antlr's '+=' operator

This way , less actions will be used, an the code will be cleaner and easier to read and mantain.

**Optional Repetition in 0+cs  **
->I dont state optionality on the parent rule like:
 definition:  IDENT '(' parameters ?')',
->  I put ? inside the non-terminal rule instead:
parameter:(variable(','variable)*)?;
That way , actions are easier to use, since I don't have to manage nulls +.
***FUNCTIONS***
In the body of a function:
 I dont use '{' definition* statement* '}'
i use  vardef* instead , because that would mean allowing structs and other functions
 to be defined within the body of a function.
***ARRAY ACCESS***
It's important to use expression in array access instead of IDENT because, we want to do things like:
functionName()[2][1];
or structname.structfield[0][9]
and so on..

*/