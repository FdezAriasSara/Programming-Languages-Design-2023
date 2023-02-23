lexer grammar Lexicon
	;

INT_CONSTANT
	: [0-9]+
	;
REAL_CONSTANT
    : [0-9]+'.'[0-9]+
    //obligatoriamente , debe haber dígitos en la parte decimal.
    ;
IDENT
    : [a-zA-Z]+(('_')?[a-zA-Z0-9])*
    //En nombre de una variable o función puede tener números y '_', pero deben empezar y terminar con un carácter.
    ;
CHAR_CONSTANT
    :'\''[a-zA-Z|'\n']'\''
    ;
LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
