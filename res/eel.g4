grammar eel;

program: procedure+ EOF;
procedure: 'procedure' ID '(' formalParams? ')' statement* 'endProcedure';
formalParams: ID (',' ID)*;
statement           : declaration
                    | controlStruct
                    | call
                    | ID assignment
                    | return;

call: FUNCTION_CALL | PROCEDURE_CALL;

declaration: 'let' ID assignment?;
assignment: '=' expression;

return: 'return' expression?;

expression          : '(' expression ')'                            #parenExpr
                    | PLUSORMINUS expression                        #unaryExpr
                    | left=expression operator right=expression     #infixExpr
                    | value                                         #valueExpr
                    ;

operator            : binaryOperator
                    | booleanOperator
                    | '='
                    ;
binaryOperator: PLUSORMINUS | MULTORDIV;
booleanOperator: BOOLEANOP;
controlStruct       : iterativeStruct
                    | selectiveStruct
                    ;
selectiveStruct: ifStruct;
ifStruct: ifCondition 'then' statement* elseIfStruct* elseStruct? 'endIf';
ifCondition: 'if' '(' expression ')';
elseIfStruct: 'else' ifCondition 'then' statement*;
elseStruct: 'else' 'then' statement*;
iterativeStruct: repeatStruct;
repeatStruct: 'repeat' 'while' '(' expression ')' statement* 'endRepeat';
value              : staticValue
                   | userValue
                   ;
staticValue: (INUM | STRING | function) method*;
function: FUNCTIONS '(' actualParams ')';
userValue          : ID
                   | IDCALL
                   ;
actualParams: value (','value)*;
method: METHODS ('(' actualParams? ')')?;


FUNCTION_CALL: FUNCTIONS '(' (PARAM? (',' WS? PARAM)*)? ')';
FUNCTIONS: 'SUM' | 'AVERAGE' | 'print';
METHODS: '.'('format' | 'count');
BOOLEANOP: [<>]'='?|'=='|'!='|'<'|'>';
PLUSORMINUS: '+'|'-';
MULTORDIV: '*'|'/';
INUM: [0-9]+;
STRING: '"' ~[\r\n"]* '"';
WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z][a-zA-Z0-9]*;
IDCALL: [a-zA-Z][a-zA-Z0-9]*'('((PARAM?)|(PARAM(','WS PARAM)*))')';
PARAM:(([a-zA-Z]+)|STRING|INUM);

