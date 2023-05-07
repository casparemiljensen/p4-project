grammar eel;

program: procedure+ EOF;
procedure: 'procedure' ID '(' formalParams? ')' statement* 'endProcedure';
formalParams: ID (',' ID)*;
statement: declaration
           | expression
           | controlStruct
           | return;

declaration: 'let' ID assignment?;
assignment: ASSIGNMENT expression;

return: 'return' expression?;

expression: left=expression operator right=expression
            | value
            | '-' expression;

operator: binaryOperator
          | booleanOperator
          | ASSIGNMENT;
binaryOperator: BINARYOP;
booleanOperator: BOOLEANOP;
controlStruct: iterativeStruct
               | selectiveStruct;
selectiveStruct: ifStruct;
ifStruct: ifCondition 'then' statement* elseIfStruct* elseStruct? 'endIf';
ifCondition: 'if' '(' expression ')';
elseIfStruct: 'else' ifCondition 'then' statement*;
elseStruct: 'else' 'then' statement*;
iterativeStruct: repeatStruct;
repeatStruct: 'repeat' 'while' '(' expression ')' statement* 'endRepeat';
value: staticValue
       | userValue;
staticValue: (INUM | STRING | function ) method*;
function: FUNCTIONS '(' actualParams ')';
userValue: ID ('(' actualParams? ')')?;
actualParams: value (','value)*;
method: METHODS ('(' actualParams? ')')?;

FUNCTIONS: 'SUM' | 'AVERAGE' | 'print';
METHODS: '.'('format' | 'count');
BOOLEANOP: [<>]'='?|'=='|'!=';
BINARYOP: '+'| '-' |'*'| '/';
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z][a-zA-Z0-9]*;
ASSIGNMENT: '=';

