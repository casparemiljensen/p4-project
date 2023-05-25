grammar eel;

program: procedure+ EOF;
procedure: 'procedure' procedureDeclaration statement* 'endProcedure';
procedureDeclaration: PROCEDURE '(' formalParams? ')';
formalParams: VARIABLE (',' VARIABLE)*;

statement           : declaration
                    | controlStruct
                    | functionCall
                    | procedureCall
                    | VARIABLE assignment
                    | cell     assignment
                    | return
                    ;
declaration: 'let' VARIABLE assignment?;
assignment: '=' expression;

return: 'return' expression;

expression          : '(' expression ')'                            #parenExpr
                    | (PLUSORMINUS | NOT) expression                #unaryExpr
                    | left=expression operator right=expression     #infixExpr
                    | value                                         #valueExpr
                    ;

operator            : binaryOperator
                    | booleanOperator
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
elseStruct: 'else then' statement*;
iterativeStruct: repeatStruct;
repeatStruct: 'repeat' 'while' '(' expression ')' statement* 'endRepeat';
value: ( INUM | FLOAT | STRING | VARIABLE | BOOLEAN | cell | functionCall | procedureCall ) method?;
cell: (SINGLE_CELL | RANGE) CELL_METHOD?;
functionCall: FUNCTIONS '(' actualParams? ')';
procedureCall: PROCEDURE '(' actualParams? ')';
method: METHODS ('(' actualParams? ')')? method?;
actualParams: value (','value)*;

//callable
FUNCTIONS: 'SUM' | 'AVERAGE' | 'print';
PROCEDURE: [A-Z][a-zA-Z0-9]*;
METHODS: '.'('count');
CELL_METHOD: '.'('value' | 'format');

//operators
BOOLEANOP: [<>]'='?|'=='|'!='|'<'|'>';
NOT: '!';
PLUSORMINUS: '+'|'-';
MULTORDIV: '*'|'/';
ASSIGNMENT: '=';

//types
BOOLEAN: 'true'|'false';
VARIABLE: [a-z][a-zA-Z0-9]*;
INUM: [0-9]+;
FLOAT: INUM'.'INUM;
STRING: '"' ~[\r\n"]* '"';
CELL: (([A-Z]+[1-9][0-9]*)|([1-9][0-9]*','[1-9][0-9]*));
SINGLE_CELL: '('CELL')';
RANGE: '{'(CELL(':'CELL)?(';'CELL(':'CELL)?)*)'}';

//spacing
WS: [ \t\r\n]+ -> skip;

