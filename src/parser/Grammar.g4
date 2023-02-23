grammar Grammar
	;
import Lexicon
	;

start: statement* EOF;

statement
    :varDef //global variable definiton
    |structDef//can only be defined on a global scope
    |functionDefinition
    ;

structDef:'struct' IDENT '{'varDef'}';
array: IDENT ':'('['INT_CONSTANT']')+

varDef:'var' variable ;

//Parameters and return value of a function can only have a simple type.

simpleType:'int'|'float'|'char'
        ;


complexType:
         | IDENT ':'('['INT_CONSTANT']')* (simpleType|complexType)';'
         |  structDef
         ;

variable
    : IDENT ':' SimpleType';'


    ;
functionDefinition
    //Parameters will be defined by a list in  EBNF's notation for 0+cs
    : IDENT'('(variable(','variable)*)?')'simpleType? '{'expression?'}'
    ;

expression
    :
    |REAL_CONSTANT
    |INT_CONSTANT
    |CHAR_CONSTANT
    |IDENT
    |//
    ;