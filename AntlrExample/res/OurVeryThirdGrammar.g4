grammar OurVeryThirdGrammar;

prog: procs EOF;
procs: proc+;
proc: 'procedure' ID '(' formalParams? ')' lines 'endProcedure';
formalParams: ID (',' ID)*;
lines: (dcl | stmt | ctrlStrc)*;
dcl: 'let' ID expr*;
stmt: value expr*;
expr: operator value;
operator: (binaryOperator | boolOperator);
binaryOperator: ('+'| '-' | '=');
boolOperator: BOOLEANOP;
ctrlStrc: (iterCtrlStrc | selCtrlStrc);
selCtrlStrc: ifStrc;
ifStrc: 'if' '(' booleanExpr ')' 'then' lines elseStrc* 'endIf';
elseStrc: 'else then' lines;
iterCtrlStrc: repeatStrc;
repeatStrc: 'repeat while' '(' booleanExpr ')' lines 'endRepeat';
booleanExpr: stmt boolOperator stmt;
value: (ID | INUM | STRING | call) method*;
call: (FUNCNAME | ID) '(' actualParams? ')';
actualParams: value (','value)*;
method: METHNAME ('(' actualParams? ')')?;


FUNCNAME: 'SUM' | 'AVERAGE';
METHNAME: '.'('format' | 'count');
BOOLEANOP: [<>]'='?|'=='|'!=';
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z][a-zA-Z0-9]*;
