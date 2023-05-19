package com.eel.parsing;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import com.eel.errors.ErrorType;
import com.eel.errors.Errors;
import com.eel.helpers.HashCodeGenerator;
import kotlin.NotImplementedError;

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

    public void Visit(ControlStructNode node) {
        if (node != null) {
            if (node.iterativeStructNode != null) {
                node.iterativeStructNode.repeatStructNode.accept(this);
            } else if (node.selectiveStructNode != null) {
                node.selectiveStructNode.ifStructNode.accept(this);
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(RepeatStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("repeat", node);
            symbolTable.enterScope(hashedName);
            node.expressionNode.accept(this);
            if (node.statementNodes != null) {
                node.statementNodes.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);
        } else {
            throw new NullPointerException();
        }
    }

    public void Visit(IfStructNode node) {
        if (node != null) {

            String hashedName = HashCodeGenerator.generateHashNameFromObject("if", node);
            symbolTable.enterScope(hashedName);
            node.ifConditionNode.expressionNode.accept(this);
            if (node.statementNodes != null) {
                node.statementNodes.forEach(s -> s.accept(this));
            }

            if (node.elseIfStructNodes != null) {
                node.elseIfStructNodes.forEach(s -> s.accept(this));
            }
            if (node.elseStructNode != null) {
                node.elseStructNode.accept(this);
            }
            symbolTable.leaveScope(hashedName);
        } else {
            throw new NullPointerException();
        }
    }


    public void Visit(ElseIfStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("elseif", node);
            symbolTable.enterScope(hashedName);
            node.ifConditionNode.expressionNode.accept(this);
            if (node.statementNodes != null) {
                node.statementNodes.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);

        }
    }

    public void Visit(ElseStructNode node) {
        if (node != null) {
            String hashedName = HashCodeGenerator.generateHashNameFromObject("else", node);
            symbolTable.enterScope(hashedName);
            if (node.statementNode != null) {
                node.statementNode.forEach(s -> s.accept(this));
            }
            symbolTable.leaveScope(hashedName);
        }
    }

    public void Visit(ExpressionNode node) {
        if (node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
                node.setType(node.parenExprNode.getType());
            } else if (node.unaryExprNode != null) {
                node.unaryExprNode.accept(this);
                node.setType(node.unaryExprNode.getType());
            } else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
                node.setType(node.infixExprNode.getType());
            } else if (node.valueExprNode != null) {
                node.valueExprNode.accept(this);
                node.setType(node.valueExprNode.getType());
                node.setName(node.valueExprNode.getName());
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }


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

    public void Visit(UnaryExprNode node) {
        if (node != null) {
            if (node.right != null && node.operator != null) {
                node.right.accept(this);
                node.setType(node.right.getType());
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


            if (operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) {
                if (
                        (left == Type.String && right == Type.String) ||
                                ((left == Type.Integer || left == Type.Float) && (right == Type.Integer || right == Type.Float))
                ) {
                    node.setType(Type.Boolean);
                } else
                    errors.addEntry(ErrorType.CANNOT_EVALUATE_COMPARISON, "'" + left + " " + operator + " " + right + "' cannot be evaluated to a boolean", node.getLineNumber(), node.getColumnNumber());


//            } else if (operator.equals("!=") || operator.equals("==")) {
//                if (left == Type.String || right == Type.String) {
//                    if (left != right)
//                        errors.addEntry(ErrorType.CANNOT_EVALUATE_EQUALITY, "The types " + left + " and " + right + " cannot be compared by equality operator", node.getLineNumber(), node.getColumnNumber());
//                    node.setType(Type.Boolean);
//                } else if (node.left.getName() == null && node.right.getName() == null)
//                    errors.addEntry(ErrorType.CANNOT_EVALUATE_EQUALITY, "The types " + left + " and " + right + " cannot be compared by equality operator", node.getLineNumber(), node.getColumnNumber());
//                else if (node.left.getType() != null && node.right.getType() != null) {
//                    if (symbolTable.lookupSymbol(node.left.getName()).getType() != Type.Variable)
//                        throw new NullPointerException();
//                    if (symbolTable.lookupSymbol(node.right.getName()).getType() != Type.Variable)
//                        throw new NullPointerException();
//                    node.setType(left);
//                } else if (node.left.getName() != null) {
//                    if (symbolTable.lookupSymbol(node.left.getName()).getType() != Type.Variable)
//                        throw new NullPointerException();
//                    node.setType(Type.Boolean);
//                } else if (node.right.getName() != null) {
//                    if (symbolTable.lookupSymbol(node.right.getName()).getType() != Type.Variable)
//                        throw new NullPointerException();
//                    node.setType(Type.Boolean);
//                } else throw new NullPointerException();


            } else if (operator.equals("+")) {
                if (left == Type.String) node.setType(Type.String);
                else if (right == Type.String) node.setType(Type.String);
                else if (left == Type.Integer && right == Type.Integer) node.setType(Type.Integer);
                else if (left == Type.Float && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Integer && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
                else
                    errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());
            } else if (operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                if (left == Type.Integer && right == Type.Integer) node.setType(Type.Integer);
                else if (left == Type.Float && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Integer && right == Type.Float) node.setType(Type.Float);
                else if (left == Type.Float && right == Type.Integer) node.setType(Type.Float);
                else
                    errors.addEntry(ErrorType.ILLEGAL_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + left + " and " + right + ".", node.getLineNumber(), node.getColumnNumber());

            } else throw new NullPointerException();
        }
    }

    public void Visit(ValueExprNode node) {
        if (node != null) {
            if (node.valueNode != null) {
                node.valueNode.accept(this);
                node.setType(node.valueNode.getType());
                node.setName(node.valueNode.getName());
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ValueNode node) {
        if (node != null) {

            if (node.STRING != null) {
                node.setType(Type.String);
            } else if (node.INUM != null) {
                node.setType(Type.Integer);
            } else if (node.FLOAT != null) {
                node.setType(Type.Float);
            } else if (node.VARIABLE != null) {
                if (symbolTable.lookupSymbol(node.VARIABLE.toString()).getDataType() == Type.Uninitialized)
                    errors.addEntry(ErrorType.VARIABLE_NOT_INITIALED, "'" + node.VARIABLE.toString() + "' has not been initialized", node.getLineNumber(), node.getColumnNumber());

                node.setType(symbolTable.lookupSymbol(node.VARIABLE.toString()).getDataType());
                node.setName(node.VARIABLE.toString());

            } else if (node.BOOLEAN != null) {
                node.setType(Type.Boolean);
            } else if (node.cellNode != null) {
                if (node.cellNode.SINGLE_CELL != null)
                    node.setType(Type.SingleCell);
                else if (node.cellNode.RANGE != null)
                    node.setType(Type.Range);
                else throw new NotImplementedError();

                if (node.cellNode.CELL_METHOD != null) {
                    if (node.cellNode.CELL_METHOD.toString().equals(".value") && node.cellNode.SINGLE_CELL != null)
                        node.setType(Type.String);
                    else if (node.cellNode.CELL_METHOD.toString().equals(".value") && node.cellNode.RANGE != null)
//                        HVAD SKAL TYPEN VÆRE HER????
                        node.setType(Type.Array);
                    else if (node.cellNode.CELL_METHOD.toString().equals(".format")) node.setType(node.getType());
                    else throw new NotImplementedError();
                }
            }
            if (node.methodNode != null) {
                node.methodNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(OperatorNode node) {
        if (node != null) {
            if (node.binaryOperatorNode != null) {
                node.setSymbol(node.binaryOperatorNode.binaryOperator.toString());
            } else if (node.booleanOperatorNode != null) {
                node.setSymbol(node.booleanOperatorNode.booleanOperator.toString());
            } else if (node.assignment != null) {
                node.setSymbol("=");
            } else throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(ReturnNode node) {
        if (node != null) {
            if (symbolTable.lookupSymbol("Return") == null) throw new NullPointerException();
            node.expressionNode.accept(this);
            node.setType(node.expressionNode.getType());

            Attributes attributes = symbolTable.lookupSymbol("Return");
            attributes.setDataType(node.expressionNode.getType());
            node.setType(node.expressionNode.getType());

            symbolTable.insertSymbol("Return", attributes);
        } else throw new NullPointerException();
    }

    @Override
    public void defaultVisit(Object o) {

    }
}
