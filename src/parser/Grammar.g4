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

variable returns [Variable ast]
        : IDENT ':' type {$ast=new Variable($type.ast,$IDENT.text);}
        ;

varDefinition returns [VarDefinition ast]
       : 'var' variable ';' {$ast=new VarDefinition($variable.ast.getName(),$variable.ast.getType()); }
       ;

parameters returns [List<Variable> list=new ArrayList<Variable>(); ]
           : (var+=variable (','var+=variable)*)? {$list=$var;}
           ;

definition returns [Definition ast]
          :  IDENT '(' parameters')' ( ':' type)? '{' localDefs+=varDefinition* sts+=statement* '}'{$ast=new FunctionDefinition($IDENT.text, $parameters.list, $type.ast, $localDefs, $sts);}
          | varDefinition {$ast=$varDefinition.ast;}
          | 'struct' IDENT '{'(fields+=variable ';')*'}'';' {$ast=new StructDefinition($IDENT.text, $fields);} //Struct definition
          ;

type  returns [Type ast]
    :'int' {$ast=new IntType();}
    |'float' {$ast=new FloatType();}
    |'char' {$ast=new CharType();}
    | ('['dimensions+=INT_CONSTANT']')+ type {$ast=new ArrayType($dimensions,$type.ast );} // var a:[i+1] int; would not be allowed.
    | IDENT {$ast=new StructType($IDENT.text );}
    ;

statement returns [Statement ast]
        :IDENT '=' expression ';' {$ast=new Assignment($IDENT.text, $expression.ast);} //Assigment
        | 'if' '('condition=expression')' '{' ifBody+=statement* '}' ( 'else'  '{' elseBody+=statement* '}' )? {$ast=new IfStatement( $condition.ast, $ifBody, $elseBody);}
        | 'while' '('condition=expression')' '{' body+=statement* '}'{$ast=new While($condition.ast, $body);}
        | 'read' expression ';' {$ast=new Read($expression.ast);}
        | variant=('print' |'printsp'|'println' ) expression? ';'{$ast=new Print($variant,$expression.ast);}
        | invocation ';'{$ast= $invocation.ast;}
        | 'return' expression ';'{$ast=new Return($expression.ast);}
        ;
invocation returns [Invocation ast]
        :IDENT '('(arguments+=expression (','arguments+=expression)*)?')' {$ast=new Invocation($IDENT.text, $arguments);}
        ; //Arguments are passed BY VALUE.

expression returns [Expression ast]
            : IDENT //{$ast=new Variable($IDENT.text);}?????????????????????????????????????? // variable ref
            | INT_CONSTANT {$ast=new IntValue($INT_CONSTANT.text);}
            | REAL_CONSTANT{$ast=new FloatValue($REAL_CONSTANT.text);}
            | CHAR_CONSTANT{$ast=new CharValue($CHAR_CONSTANT.text);}
            | left=expression operator=('*'|'/') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('+'|'-') right=expression {$ast=new ArithmeticExpression($left.ast, $operator, $right.ast);}
            | left=expression operator=('>'|'<'|'>='|'<='|'=='|'!=') right=expression {$ast=new Comparison($left.ast, $operator, $right.ast);}
            | expression '&&' expression {$ast=new And($left.ast , $right.ast);}
            | expression '||' expression {$ast=new Or($left.ast, $right.ast);}
            | '!' expression {$ast=new Not($expression.ast);}
            | '<'type'>' '('expression')' {$ast=new Cast($type.ast,$expression.ast);}
            | array=expression ('['dimensions+=expression']')+ {$ast=new ArrayAccess($array.ast,$dimensions);}
            | struct=expression'.' IDENT {$ast=new StructFieldAccess($struct.ast,$IDENT.text);}//struct field access.
            | invocation {$ast=$invocation.ast;}//Invocations can appear as sentences or expressions.
            | '('expression')'
            ;




//PREGUNTAS:
//______________PREGUNTA 1---------------------
// Variable, puede ser o no expression... Debería el Objeto variable tener Type?
// En la gramática abstracta tengo Variable:expression -> name:string;
//  ->Entonces como haríamos en IDENT (variable como  expression)?
//      ->podría modificar y añadir un constructor a mano que no requiera el tipo? y que se asigne en asignación de tipos?
//______________RESPUESTA_PREGUNTA 1---------------------

//______________PREGUNTA 2---------------------
// Es correcto que las dimensiones de array se especifiquen como IntType y no un integer normal de java?
//  ->al generar con vgen, cuando intenté utilizar el int de java: "WARNING. Recuerde implementar la clase 'Integer' (se usa en el nodo "ArrayType" pero no ha sido definida como Categor´┐¢a o Nodo)."
//______________RESPUESTA_PREGUNTA 2---------------------
//______________PREGUNTA 3---------------------
//En la regla de  ARRAY ACCESS? EXPRESSION O IDENT? En clase (teoría) usamos una expresión , ya que estas podían ser de tipos compuestos
//______________RESPUESTA_PREGUNTA 3---------------------
//______________PREGUNTA 4---------------------
//AGRUPACIÓN CON PARÉNTESIS SE GENERA NODO "in situ" O SE GENERA EN LA EXPRESION?
//______________RESPUESTA_PREGUNTA 4---------------------
//______________PREGUNTA 5---------------------
//comprobar que el character_constant esta bien en lexicon.g4

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