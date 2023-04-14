grammar OurVeryFirstGrammar;
 
prog: procs EOF;
procs: proc+ | EPSILON;
proc: 'procedure' ID '(' formalParams? ')' procBody 'endProcedure';
 
formalParams: formalParam formalParamTail?;
formalParamTail: ',' formalParam formalParamTail? | EPSILON ;
formalParam: ID;
 
procBody: lines;
lines: dcl* stmt* ctrlStruc*;
dcl: 'let' ID exprs;
stmt: value exprs?;
exprs: expr exprs? | EPSILON;
expr: operator value;
operator: binaryOperator | boolOperator;
binaryOperator: '+' | '-' | '=';
boolOperator: 'greater' | 'greaterEqual' | 'less' | 'lessEqual' | 'equal' | 'notequal' | 'and' | 'or' | 'not' | 'xor';
 
ctrlStruc: iterCtrlStruc | selCtrlStruc;
selCtrlStruc: ifStrc;
ifStrc: 'if' '(' booleanExpr ')' 'then' lines elseStrc? 'endIf';
elseStrc: 'else' 'then' lines? | EPSILON;
iterCtrlStruc: repeatStrc;
repeatStrc: 'repeat' 'while' '(' booleanExpr ')' lines 'endRepeat';
 
booleanExpr: stmt boolOperator stmt;
 
value: ID | INUM | STRING | funcCall;
funcCall: 'funcName' '(' actualParams? ')';
actualParams: actualParam actualParamTail? | EPSILON;
actualParamTail: ',' actualParam actualParamTail? | EPSILON;
actualParam: ID;
 
ID: [a-zA-Z]+;
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;
