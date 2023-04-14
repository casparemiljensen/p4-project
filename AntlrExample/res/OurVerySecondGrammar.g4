grammar OurVerySecondGrammar;

prog: procs EOF;
procs: proc+;
proc: 'procedure' ID '(' formalParams? ')' lines 'endProcedure';
formalParams: ID (','ID)*;
lines: dcl* stmt* ctrlStrc*;
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
value: (ID | INUM | STRING | FuncCall);
funcCall: FUNCNAME '(' ActualParams? ')';
actualParams: ID (','ID)*;
 
ID: [a-zA-Z]+;
FUNCNAME: [a-zA-Z]+;
BOOLEANOP: [<>]'='?|'=='|'!=';
//BOOLEANOP: (<|>|<=|>=|==|!=)$;
//booleanop: and, or, not
//comparisonop:
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;

