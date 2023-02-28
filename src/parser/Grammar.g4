grammar Grammar
	;
import Lexicon
	;

start: definition* EOF;

variable: IDENT ':' type;
vardef: 'var' variable ';';

definition:  IDENT parameters ( ':' type)? '{' vardef* statement* '}'
            | vardef
            | 'struct' IDENT '{'(variable ';')*'}'//struct definition
            | IDENT':'type('['expression']')+//array definition
            ;

type: 'int'|'float'|'char';


parameters:'('(variable (','variable)*)?')' ;// Parenthesis must appear but params are optional


statement:invocation ';'
        | IDENT '=' expression ';' //Assigment
        | 'if' '('expression')' '{' statement* '}' ( 'else'  '{' statement* '}' )?
        | 'while' '('expression')' '{' statement* '}'
        | 'read' expression ';'
        | ('print' |'printsp'|'println' ) expression? ';'
        | invocation ';'
        | 'return' expression ';'
        ;
invocation :IDENT '('(expression (','expression)*)?')' ; //Arguments are passed BY VALUE.

expression:  INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | IDENT
            | expression ('*'|'/') expression
            | expression ('+'|'-') expression
            | expression ('>'|'<'|'>='|'<='|'=='|'!=') expression
            | expression '&&' expression
            | expression '||' expression
            | '!' expression
            | '<'type'>' '('expression')' //cast
            | expression ('['expression']')+//Array access
            | expression '.' expression //accessing struct field.
            | invocation //Invocations can appear as sentences or expressions.
            | '('expression')'
            ;