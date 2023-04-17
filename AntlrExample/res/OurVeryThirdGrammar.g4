grammar OurVeryThirdGrammar;

prog: procs EOF;
procs: proc+;
proc: 'procedure' ID '(' formalParams? ')' lines 'endProcedure';
formalParams: ID (',' ID)*;
lines: (dcl | stmt | ctrlStrc)*;
dcl: 'let' ID expr*;
stmt: ('return'? value expr*) | 'return';
expr: operator value;
operator: (binaryOperator | boolOperator);
binaryOperator: ('+'| '-' |'*'| '/' | '=');
boolOperator: BOOLEANOP;
ctrlStrc: (iterCtrlStrc | selCtrlStrc);
selCtrlStrc: ifStrc;
ifStrc: ifCond 'then' lines elseIfStrc* elseStrc? 'endIf';
ifCond: 'if' '(' booleanExpr ')';
elseIfStrc: 'else' ifCond lines;
elseStrc: 'else' 'then' lines;
iterCtrlStrc: repeatStrc;
repeatStrc: 'repeat' 'while' '(' booleanExpr ')' lines 'endRepeat';
booleanExpr: stmt boolOperator stmt;
value: (ID | INUM | STRING | call) method*;
call: (FUNCTIONS | ID) '(' actualParams? ')';
actualParams: value (','value)*;
method: METHODS ('(' actualParams? ')')?;

FUNCTIONS: 'SUM' | 'AVERAGE' | 'print';
METHODS: '.'('format' | 'count');
BOOLEANOP: [<>]'='?|'=='|'!=';
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z][a-zA-Z0-9]*;
