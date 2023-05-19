package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import kotlin.NotImplementedError;
import org.w3c.dom.Attr;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SemanticVisitor extends ReflectiveASTVisitor {

    SymbolTable symbolTable;
    Errors errors;
    private ProgramNode ast;

    public SemanticVisitor(SymbolTable symbolTable, Errors errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;

    }

    public void Visit(ProgramNode node) {
        this.ast = node;
        if (node.procedureNodes != null) {
            List<ProcedureNode> procs = node.procedureNodes.stream().filter(p -> p.procedureDeclarationNode.procedureToken.toString().equals("Main")).collect(Collectors.toList());
            if (procs.size() > 0) {
                procs.get(0).accept(this);
                var obj = procs.get(0);
                System.out.println(obj);
            } else {
                errors.addEntry(ErrorType.MAIN_PROCEDURE_MISSING, " no Main procedure declared");
            }
        }
//            for (ProcedureNode procedureNode : node.procedureNodes) {
//                symbolTable.enterScope(procedureNode.procedureDeclarationNode.procedureToken.toString());
//                procedureNode.accept(this);
//                symbolTable.leaveScope();
//            }
    }

    public void Visit(ProcedureNode node) {
        if (node.StatementNodes != null) {

            symbolTable.enterScope(node.procedureDeclarationNode.procedureToken.toString());
            for (StatementNode statementNode : node.StatementNodes) {
                statementNode.accept(this);
            }
            symbolTable.leaveScope();
        }
    }

    public void Visit(StatementNode node) {
        if (node.declarationNode != null) {
            node.declarationNode.accept(this);
        } else if (node.controlStructNode != null) {
            node.controlStructNode.accept(this);
        } else if (node.functionCallNode != null) {
            node.functionCallNode.accept(this);
        } else if (node.procedureCallNode != null) {
            node.procedureCallNode.accept(this);
        } else if (node.terminal != null) {
            if (symbolTable.lookupSymbol(node.terminal.toString()) != null) {
                node.assignmentNode.accept(this);
                Attributes attributes = symbolTable.lookupSymbol(node.terminal.toString());
                attributes.setDataType(node.assignmentNode.getType());
                symbolTable.insertSymbol(node.terminal.toString(), attributes);
                node.setType(node.assignmentNode.getType());
            }
        } else if (node.cellNode != null) {
            node.cellNode.accept(this);
            node.assignmentNode.accept(this);
        } else if (node.returnNode != null) {
            node.returnNode.accept(this);
        } else
            throw new NotImplementedError();
    }


    public void Visit(DeclarationNode node) {
        if (node != null) {
            if (node.assignmentNode != null) {
                node.assignmentNode.accept(this);
                Attributes attributes = symbolTable.lookupSymbol(node.IdToken.toString());
                attributes.setDataType(node.assignmentNode.getType());
                node.setType(node.assignmentNode.getType());
                symbolTable.insertSymbol(node.IdToken.toString(), attributes);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(AssignmentNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                node.expressionNode.accept(this);
                node.setType(node.expressionNode.getType());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ProcedureCallNode node) {
        if (node != null) {
            // Updating the types of the formalParams to that of the actualParams...
            if (symbolTable.lookupSymbol(node.PROCEDURE.toString()) != null) {
                // Retrieve procedure information from the symbol table
                // Check count for both
                symbolTable.enterScope(node.PROCEDURE.toString());
                if (node.actualParamsNode != null) {
                    // Making sure that amount of formalParams == actualParams
                    if (symbolTable.currentScope.getParams().size() != node.actualParamsNode.valuesNodes.size()) {
                        System.out.println("size: " + symbolTable.currentScope.getParams().size());
                        errors.addEntry(ErrorType.PARAMETERS_COUNT_MISMATCH, symbolTable.currentScope.getParams().size() + " parameters expected, " + node.actualParamsNode.valuesNodes.size() + " provided", node.getLineNumber(), node.getColumnNumber());
                    } else {
                        // Only visiting if there is some actualParams
                        if (node.actualParamsNode != null) {
                            node.actualParamsNode.accept(this);

                            List<ValueNode> vars = node.actualParamsNode.valuesNodes.stream().filter(v -> v.getType() == Type.Variable).collect(Collectors.toList());
                            if (vars != null) {
                                for (ValueNode v : vars) {

                                    if (symbolTable.lookupSymbol(v.VARIABLE.toString()) == null) {
                                        errors.addEntry(ErrorType.UNDECLARED_VARIABLE, "A variable with the name: " + v.VARIABLE.toString() + " has not been declared ", v.getLineNumber(), v.getColumnNumber());
                                    } else if (symbolTable.lookupSymbol(v.VARIABLE.toString()) != null) {
                                        // THIS IS NOT BEING HIT... It is maybe because our lookup symbol function has been added a boolean for nest checks...
                                        Attributes attr = symbolTable.lookupSymbol(v.VARIABLE.toString());
                                        if (attr.getDataType() == Type.Uninitialized) {
                                            errors.addEntry(ErrorType.UNINITIALIZED_VARIABLE, "A variable with the name: " + v.VARIABLE.toString() + " has not been initialized, and will infer null type ", v.getLineNumber(), v.getColumnNumber());
                                        }
                                    }
                                }
                            }

                            // Get the HashMap object from the symbol table
                            Map<String, Attributes> obj = symbolTable.currentScope.getParams();

                            // Get the list of actual parameters
                            List<ValueNode> actualParams = node.actualParamsNode.valuesNodes;

                            // Get an iterator over the entry set of the HashMap
                            Iterator<Map.Entry<String, Attributes>> iterator = obj.entrySet().iterator();

                            // Iterate over the actualParams list and update the values in the HashMap
                            for (ValueNode paramValue : actualParams) {
                                if (iterator.hasNext()) {
                                    // Get the next entry from the HashMap
                                    Map.Entry<String, Attributes> entry = iterator.next();

                                    // Update the value in the entry with the corresponding actual parameter value
                                    Attributes attr = entry.getValue();
                                    attr.setDataType(paramValue.getType());

                                    entry.setValue(attr);
                                } else {
                                    // Handle the case where there are more actual parameters than formal parameters
                                    System.out.println("Error: More actual parameters than formal parameters");
                                    break;
                                }
                            }
                            findProcedure(node.PROCEDURE.toString()).accept(this);

                        }
                    }
                    // Perform additional type checking or validation for the procedure call if needed
                }

//                Visit(node.PROCEDURE.toString());


                symbolTable.leaveScope(node.PROCEDURE.toString());
            } else {
                errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, " A procedure with the name: '" + node.PROCEDURE.toString() + "' does not exist", node.getLineNumber(), node.getColumnNumber());
            }
        }
    }

    private ProcedureNode findProcedure(String procedureName) {
        // Iterate through a list of defined procedures or methods and find the one with a matching name
        for (ProcedureNode procedureNode : ast.procedureNodes) {
            if (procedureNode.procedureDeclarationNode.procedureToken.toString().equals(procedureName)) {
                return procedureNode;
            }
        }

        // Return null if the procedure or method is not found
        return null;
    }

    public void Visit(ActualParamsNode node) {
        if (node != null) {
            for (ValueNode valueNode : node.valuesNodes) {
                valueNode.accept(this);
            }
        }
    }

    // Dette er duplicate kode fra BSTV...
    public void Visit(ValueNode node) {
        if (node != null) {
            if (node.STRING != null) {
                node.setType(Type.String);
            } else if (node.INUM != null) {
                node.setType(Type.Integer);
            } else if (node.FLOAT != null) {
                node.setType(Type.Float);
            } else if (node.VARIABLE != null) {
                node.setType(Type.Variable);
            } else if (node.BOOLEAN != null) {
                node.setType(Type.Boolean);
            } else if (node.cellNode != null) {
                if (node.cellNode.SINGLE_CELL != null)
                    node.setType(Type.SingleCell);
                else if (node.cellNode.RANGE != null)
                    node.setType(Type.Range);
                else throw new NotImplementedError();

                // Skal vi stadig sætte de her typer???

                if (node.cellNode.CELL_METHOD != null) {
                    if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.SINGLE_CELL != null)
                        node.setType(Type.Integer);
                    else if (node.cellNode.CELL_METHOD.toString() == "value" && node.cellNode.RANGE != null)
                        node.setType(Type.Array);
                    else if (node.cellNode.CELL_METHOD.toString() == "format") node.setType(node.getType());
                    else throw new NotImplementedError();
                }
            }
            if (node.methodNode != null) {
                node.methodNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }


    public void Visit(ExpressionNode node) {
        if (node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
                node.setType(node.parenExprNode.getType());
            } else if (node.unaryExprNode != null) {
            } else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
                node.setType(node.infixExprNode.getType());
            } else if (node.valueExprNode != null) {
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    // Nødvendigt onde at have denne i SemanticVisitor. Vi ville hellere have visit(ParenExprNode) i BSTV, Så vi kun har typeChecking logikken her i SemanticVisitor.
    // Desværre besøger ExpressionNode, som kan besøge InfixExpressionNod, der først får sin type her i SemanticVisitor
    public void Visit(ParenExprNode node) {
        // Hackish char null check
        if (node != null) {
            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
                node.expressionNode.accept(this);
                node.setType(node.expressionNode.getType());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(InfixExprNode node) {
        if (node.left != null && node.operatorNode != null && node.right != null) {
            node.left.accept(this);
            node.operatorNode.accept(this);
            node.right.accept(this);

            Enum<Type> left = node.left.getType();
            Enum<Type> right = node.right.getType();
            String operator = node.operatorNode.getSymbol();

//            if (left == Type.Unresolved) {
//                System.out.println("Nodename: " + node.left.getName());
//
//                if (symbolTable.lookupSymbol(node.left.getName()) != null) {
//                    System.out.println("Nodename: " + node.left.getName());
//                }
//            }
//            if (right == Type.Unresolved) {
//
//            }


            if (left == Type.Variable) {
                if (symbolTable.lookupSymbol(node.left.getName()) != null) {
                    if (symbolTable.lookupSymbol(node.left.getName()).getDataType() == Type.Uninitialized)
                        System.out.println(node.left.getName() + " has not been assigned a VALUE");
                    else if (symbolTable.lookupSymbol(node.left.getName()).getDataType() == Type.Unresolved) {
                        System.out.println("");
                    }
                    left = symbolTable.lookupSymbol(node.left.getName()).getDataType();
                }
            } else {
                // TJEK I PAREN cope hvis nuværende er i eller else if eller else
                System.out.println(node.left.getName() + " has not been DECLARED");
            }


            if (right == Type.Variable) {
                if (symbolTable.lookupSymbol(node.right.getName()) != null) {
                    if (symbolTable.lookupSymbol(node.right.getName()).getDataType() == Type.Uninitialized)
                        System.out.println(node.right.getName() + " has not been assigned a VALUE");
                    right = symbolTable.lookupSymbol(node.right.getName()).getDataType();
                } else {
                    // TJEK I PAREN cope hvis nuværende er i eller else if eller else
                    System.out.println(node.right.getName() + " has not been DECLARED");
                }
            }

            if (left != right) {

                if (operator.equals("+") && (left == Type.String || right == Type.String)) node.setType(Type.String);
                    // Ikke slet!
//                    else if (!operator.equals("+") && (right != Type.Integer || right != Type.Float)) errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "righthand side of expression can only be number", node.getLineNumber(), node.getColumnNumber());
                else if (left == Type.Integer && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
                else
                    errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());
            } else node.setType(node.left.getType());
        }
    }


    @Override
    public void defaultVisit(Object o) {

    }
}
