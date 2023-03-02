lexer grammar Lexicon
	;

INT_CONSTANT
	: [0-9]+
	;
REAL_CONSTANT
    : [0-9]+'.'[0-9]+
    //It's mandatory that there are digits on the decimal part.
    ;
    CHAR_CONSTANT
        :'\'\\n\''
        |'\''~[ \t\r\n]'\''
        ;

IDENT
    : [a-zA-Z]+(('_')?[a-zA-Z0-9])*
    ;//Identifiers must start  with a character. It's possible that they have hypens or numbers inbetween.
    //They can either begin with a character or a number.

LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
