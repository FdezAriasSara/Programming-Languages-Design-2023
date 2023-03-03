grammar Grammar
	;
import Lexicon
	;

start: definition* EOF;

variable: IDENT ':' type;
vardef: 'var' variable ';';

definition:  IDENT parameters ( ':' type)? '{' vardef* statement* '}'//FUNCTION DEFINITION.
            | vardef
            | 'struct' IDENT '{'(variable ';')*'}'';' //Struct definition
            ;

type:'int'
    |'float'
    |'char'
    | ('['INT_CONSTANT']')+ type // var a:[i+1] int; would not be allowed.
    | IDENT //For Structs ->var empleado: Persona;
    ;


parameters:'('(variable (','variable)*)?')' ;// Parenthesis must appear but params are optional


statement:IDENT '=' expression ';' //Assigment
        | 'if' '('expression')' '{' statement* '}' ( 'else'  '{' statement* '}' )?
        | 'while' '('expression')' '{' statement* '}'
        | 'read' expression ';'
        | ('print' |'printsp'|'println' ) expression? ';'
        | invocation ';'
        | 'return' expression ';'
        ;
invocation :IDENT '('(expression (','expression)*)?')' ; //Arguments are passed BY VALUE.

expression:  IDENT // variable ref
            |INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | expression ('*'|'/') expression
            | expression ('+'|'-') expression
            | expression ('>'|'<'|'>='|'<='|'=='|'!=') expression
            | expression '&&' expression
            | expression '||' expression
            | '!' expression
            | '<'type'>' '('expression')' //cast
            | expression ('['expression']')+//Array access
            | expression'.' IDENT //accessing struct field.
            | invocation //Invocations can appear as sentences or expressions.
            | '('expression')'
            ;