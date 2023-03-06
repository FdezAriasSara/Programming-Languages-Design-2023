grammar Grammar
	;
import Lexicon
	;

start returns[Program ast]
    : definitions+=definition* EOF {$ast=new Program($definitions);}
    ;
variable returns [Variable ast]
        : IDENT ':' type {$ast=new Variable($IDENT.text,type.ast);}
        ;
varDefinition returns [Variable ast]
       : 'var' variable ';' {$ast=variable;};
parameters returns [List<Variable> list=new ArrayList<Variable>(); ]
           :(var+=variable (','var+=variable)*)? {$list=var:}  ;
definition returns [Definition ast]
            :  IDENT '(' parameters')' ( ':' type)? '{' localDefs+=varDefinition* sts+=statement* '}'{$ast=new FunctionDefinition( parameters.list, type.ast, $localDefs, $sts);}
            | varDefinition {$ast=varDefinition.ast;}
            | 'struct' IDENT '{'(fields+=variable ';')*'}'';' {$ast=new StructDefinition($IDENT.text, $fields);} //Struct definition
            ;
type  returns [Type ast]
    :'int' {$ast=new IntType();}
    |'float' {$ast=new FloatType();}
    |'char' {$ast=new CharType();}
    | ('['INT_CONSTANT']')+ type {$ast=new ArrayType(,$type.ast );}
     // var a:[i+1] int; would not be allowed.
    | IDENT {$ast=new StructType($IDENT.text );}
    ;
statement returns [Statement ast]
        :IDENT '=' expression ';' {$ast=new Assigment($IDENT.text, $expression.ast);} //Assigment
        | 'if' '('condition=expression')' '{' ifBody+=statement* '}' ( 'else'  '{' elseBody+=statement* '}' )? {$ast=new If($IDENT.text, $condition.ast, $ifBody.ast, $elseBody.ast);}
        | 'while' '('condition=expression')' '{' body+=statement* '}'{$ast=new While($condition.ast, $body);}
        | 'read' expression ';' {$ast=new Read($expression.ast;}
        | variant=('print' |'printsp'|'println' ) expression? ';'{$ast=new Print($variant,$expression.ast);}
        | invocation ';'{$ast= $invocation.ast;}
        | 'return' expression ';'{$ast=new Return($expression.ast);}
        ;
invocation returns [Invocation ast]
        :IDENT '('(arguments+=expression (','arguments+=expression)*)?')' {$ast=new Invocation($IDENT.text, $arguments);}
        ; //Arguments are passed BY VALUE.

expression returns [Expression ast]
            : IDENT // variable ref
            | INT_CONSTANT {$ast=new IntValue($INT_CONSTANT.text);}
            | REAL_CONSTANT{$ast=new RealValue($REAL_CONSTANT.text);}
            | CHAR_CONSTANT{$ast=new Character($CHAR_CONSTANT.text);}
            | left=expression operator=('*'|'/') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('+'|'-') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('>'|'<'|'>='|'<='|'=='|'!=') right=expression {$ast=new Comparison($left.ast, $operator, $right.ast);}
            | expression '&&' expression {$ast=new And($left.ast , $right.ast);}
            | expression '||' expression {$ast=new Or($left.ast, , $right.ast);}
            | '!' expression {$ast=new Not($expression.ast);}
            | '<'type'>' '('expression')' {$ast=new Cast($type.ast,$expression.ast);}
            | array=expression ('['dimensions+=expression']')+ {$ast=new ArrayAccess($array.ast,$dimensions);}
            | struct=expression'.' IDENT {$ast=new StructFieldAccess($struct.ast,$IDENT.text);}//struct field access.
            | invocation {$ast=invocation.ast;}//Invocations can appear as sentences or expressions.
            | '('expression')'
            ;




//PREGUNTAS: ARRAY ACCESS? EXPRESSION O IDENT?
//AGRUPACIÓN CON PARÉNTESIS?
//comprobar que el character_constant esta bien


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