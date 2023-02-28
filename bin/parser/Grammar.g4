grammar Grammar
	;
import Lexicon
	;

start: definition* EOF;

variable: IDENT ':' type;
vardef: 'var' variable ';';

definition:  IDENT '(' parameters? ')' ( ':' type)? '{' vardef* statement* '}'
            | vardef
            | 'struct' IDENT '{'(variable ';')*'}'//struct definition
            | IDENT':'type('['expression']')+//array definition
            ;

type: 'int'|'float'|'char';


parameters: variable  //using list pattern for zero or more (using separators)
          | variable ',' parameters
          ;//variable would be lOpt



arguments: expression  //using list pattern for zero or more (using separators)
           |expression ',' arguments
           ;//expression would be LOpt
           //Arguments are passed BY VALUE.

statement:invocation ';'
        | IDENT '=' expression ';' //Assigment
        | 'if' '('expression')' '{' statement* '}' ( 'else'  '{' statement* '}' )? //simplificate?
        | 'while' '('expression')' '{' statement* '}'
        | ('print' |'printsp'|'println' ) expression? ';'
        | invocation ';'
        | 'return' expression ';'
        ;
invocation :IDENT '('arguments')' ;

expression:  INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | IDENT
            | expression ('*'|'/')expression
            | expression ('+'|'-')expression
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