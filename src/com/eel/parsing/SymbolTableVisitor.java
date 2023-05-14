//package com.eel.parsing;
//
//import com.eel.AST.ReflectiveASTVisitor;
//import com.eel.AST.nodes.*;
//import com.eel.errors.ErrorType;
//import com.eel.errors.Errors;
//import kotlin.NotImplementedError;
//
//import java.util.Map;
//
//public class SymbolTableVisitor extends ReflectiveASTVisitor {
//    SymbolTable symbolTable;
//    Errors errors;
//
//    public SymbolTableVisitor(SymbolTable symbolTable, Errors errors){
//        this.symbolTable = symbolTable;
//        this.errors = errors;
//    }
//
//    public void Visit(ProgramNode node) {
//        if (node.procedureNodes != null) {
//            for (ProcedureNode procedureNode : node.procedureNodes) {
//                procedureNode.accept(this);
//            }
//        }
//        printSymbolTable();
//    }
//    public void Visit(ProcedureNode node) {
//        if (symbolTable.lookupSymbol(node.procedureDeclarationNode.procedureToken.toString()) != null) {
//            errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Procedure '" + node.procedureDeclarationNode.procedureToken.toString() + "' already exists", node.getColumnNumber(), node.getLineNumber());
//        }
//        else {
//            //Creates and adds the function to the symbol table
//            Attributes attributes = new Attributes("procedure", node.getType());
//            symbolTable.insertSymbol(node.procedureDeclarationNode.procedureToken.toString(), attributes);
//
//            symbolTable.addScope(node.procedureDeclarationNode.procedureToken.toString());
//            //symbolTable.addScope(node.getNodeHash());
//            for (StatementNode statementNode : node.StatementNodes) {
//                statementNode.accept(this);
//            }
//            symbolTable.leaveScope();
//        }
//    }
//
//    public void Visit(StatementNode node) {
//        if(node != null) {
//            if (node.declarationNode != null) {
//                node.declarationNode.accept(this);
//            } else if (node.controlStructNode != null) {
//                node.controlStructNode.accept(this);
//            } else if (node.callNode != null) {
//                node.callNode.accept(this);
//            } else if (node.assignmentNode != null) {
//                node.assignmentNode.accept(this);
//            } else if (node.returnNode != null) {
//                node.returnNode.accept(this);
//            }
//
//            // And what about the terminalNode?
//            else
//                throw new NotImplementedError();
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(DeclarationNode node) {
//        if(node != null) {
//            declareNode(node, node.getType());
//
//            if(node.assignmentNode != null) {
//                node.assignmentNode.accept(this);
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ControlStructNode node) {
//        if(node != null) {
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(RepeatStructNode node) {
//        if (node != null) {
//        } else {
//            throw new NullPointerException();
//        }
//    }
//
//    public void Visit(IfStructNode node) {
//        if(node != null) {
//
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(AssignmentNode node) {
//        if(node != null) {
//            if(node.expressionNode != null) {
//                node.expressionNode.accept(this);
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ExpressionNode node) {
//        if(node != null) {
//            if (node.parenExprNode != null) {
//                node.parenExprNode.accept(this);
//                node.setType(node.parenExprNode.getType());
//            }
//            else if (node.unaryExprNode != null) {
//                node.unaryExprNode.accept(this);
//                node.setType(node.unaryExprNode.getType());
//            }
//            else if (node.infixExprNode != null) {
//                node.infixExprNode.accept(this);
//                node.setType(node.infixExprNode.getType());
//            }
//            else if (node.valueExprNode != null) {
//                node.valueExprNode.accept(this);
//                node.setType(node.valueExprNode.getType());
//            }
//            else
//                throw new NotImplementedError();
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ParenExprNode node) {
//        // Hackish char null check
//        if(node != null) {
//            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
//                node.expressionNode.accept(this);
//                node.setType(node.expressionNode.getType());
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(UnaryExprNode node) {
//        if(node != null) {
//            if (node.right != null && node.operator != null) {
//                node.right.accept(this);
//                node.setType(node.right.getType());
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(InfixExprNode node) {
//        if(node != null) {
//            if (node.left != null && node.operatorNode != null && node.right != null) {
//                node.left.accept(this);
//                node.operatorNode.accept(this);
//                node.right.accept(this);
//
//                if (node.left.getType() != node.right.getType()) {
//                    errors.addEntry(ErrorType.IMPLICIT_TYPE_CONVERSION, "Not possible to implicitly convert types in expression. Types: " + node.left.getType() + " and " + node.right.getType() + ".", node.getLineNumber(), node.getColumnNumber());
//                }
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ValueExprNode node) {
//        if(node != null) {
//            if (node.valueNode != null) {
//                node.valueNode.accept(this);
//                node.setType(node.valueNode.getType());
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(ValueNode node) {
//        if(node != null) {
//
//            if (node.staticValueNode != null) {
//                node.staticValueNode.accept(this);
//                node.setType(node.staticValueNode.getType());
//            } else if (node.userValueNode != null) {
//                node.userValueNode.accept(this);
//                node.setType(node.userValueNode.getType());
//            } else
//                throw new NotImplementedError();
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(StaticValueNode node) {
//        if(node != null) {
//            if (node.STRING != null) {
//                node.setType(Type.String);
//            }
//            else if (node.INUM != null) {
//                node.setType(Type.Integer);
//            }
////            else if(node.FLOAT != null) {
////                node.setType(Type.Float);
////            }
//            else if (node.FUNCTION != null) {
//                node.setType(Type.Function);
//            }
//            if (node.methodNode != null) {
//                node.methodNode.accept(this);
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(UserValueNode node) {
//        if(node != null) {
//            if (node.ID != null) {
//                throw new NotImplementedError();
//
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//
//    private void declareNode(DeclarationNode node, Enum<Type> type) {
//        //Enters if the node is not already in the symbol table
//        if (!isDeclared(node)) {
//            //Creates and adds the node to the symbol table
//            Attributes attribute = new Attributes("dcl", type);
//            symbolTable.insertSymbol(node.IdToken.toString(), attribute);
//        }
//
//    }
//
//    private boolean isDeclared(DeclarationNode node) {
//        if (symbolTable.lookupSymbol(node.IdToken.toString()) != null){
//            errors.addEntry(ErrorType.DUPLICATE_VARIABLE, "Variable '" + node.IdToken.toString() + "' already exists", node.getLineNumber(), node.getColumnNumber());
//            // node.type = symbolTable.lookupSymbol(node.IdToken.toString()).getVariableType();
//
//            return true;
//        }
//        return false;
//    }
//
//    public void Visit(OperatorNode node) {
//        if(node != null) {
//            if (node.binaryOperatorNode != null) {
//                node.binaryOperatorNode.accept(this);
//            }
//            else if (node.booleanOperatorNode != null) {
//                node.booleanOperatorNode.accept(this);
//            }
//            else
//                throw new NotImplementedError();
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(BinaryOperatorNode node) {
//        if(node != null) {
//            if (node.binaryOperator != null) {
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    public void Visit(BooleanOperatorNode node) {
//        if (node != null) {
//            if (node.booleanOperator != null) {
//            }
//        }
//        else
//            throw new NullPointerException();
//    }
//
//    @Override
//    public void defaultVisit(Object o) {
//
//    }
//
//
//    private void printSymbolTable() {
//        printScope(symbolTable.globalScope);
//    }
//
//    private void printScope(EelScope scope) {
//        System.out.println("Scope: " + scope.getScopeName());
//        System.out.println("Symbols:");
//        for (Map.Entry<String, Attributes> entry : scope.getSymbols().entrySet()) {
//            String symbol = entry.getKey();
//            Attributes attributes = entry.getValue();
//            System.out.println("  Symbol: " + symbol);
//            System.out.println("  Attributes:");
//            System.out.println("    Type: " + attributes.getKind());
//            // Add more attribute printing if needed
//            System.out.println();
//        }
//
//        for (EelScope childScope : scope.children) {
//            printScope(childScope);
//        }
//    }
//}
