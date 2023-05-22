package com.eel;

import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.*;
import kotlin.NotImplementedError;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Objects;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;

public class Generator extends ReflectiveASTVisitor {
    public StringBuilder strBlr;

    public Generator() {
        strBlr = new StringBuilder();
    }

    private HashMap<TerminalNode, TerminalNode> cellAccessor = new HashMap<>();

    public void Visit(ProgramNode node) {
        if (node != null) {
            strBlr.append(getIndentation()).append("function main (workbook: ExcelScript.Workbook) {\n");
            increaseIndent();
            for (ProcedureNode procedureNode : node.procedureNodes) {
                procedureNode.accept(this);
            }
            // Always run main()
            strBlr.append("\n").append(getIndentation()).append("main()\n");
            decreaseIndent();
            strBlr.append(getIndentation()).append("}\n");

            String content = loadEelLibFile();
            if (content != null) {
                strBlr.append(content);
            }

            System.out.println(strBlr.toString());
            writeToFile(strBlr.toString());
        } else
            throw new NullPointerException();
    }

    public static String loadEelLibFile() {
        String filePath = "out/production/eel/com/eel/EelLib.ts";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToFile(String content) {
        String filePath = "out/production/eel/com/eel/OutputCode.ts";
        try {
            Path path = Paths.get(filePath);
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Visit(ProcedureNode node) {
        if (node != null) {

            // The line below it necessary because EEL addes () after proc calls but this is not used in the same way if OfficeScripts.
            String inputProcName = node.procedureDeclarationNode.procedureToken.toString();
            String outputProcName = inputProcName.replace("(", "").replace(")", "");
            if (outputProcName.equals("Main")) {
                strBlr.append(getIndentation()).append("function " + outputProcName.toLowerCase() + "(");
            } else {
                strBlr.append(getIndentation()).append("function " + outputProcName + "(");
            }

            if (node.procedureDeclarationNode.formalParametersNode != null) {
                node.procedureDeclarationNode.formalParametersNode.accept(this);
            }
            strBlr.append(") {\n");
            increaseIndent();

            for (StatementNode statementNode : node.StatementNodes) {
                strBlr.append(getIndentation());

                if (statementNode.cellNode != null && statementNode.assignmentNode != null) {
                    if (statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.STRING != null)
                        cellAccessor.put(statementNode.cellNode.SINGLE_CELL, statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.STRING);
                    if (statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.INUM != null)
                        cellAccessor.put(statementNode.cellNode.SINGLE_CELL, statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.INUM);
                    if (statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.FLOAT != null)
                        cellAccessor.put(statementNode.cellNode.SINGLE_CELL, statementNode.assignmentNode.expressionNode.valueExprNode.valueNode.FLOAT);
                }

                statementNode.accept(this);
            }
            decreaseIndent();
            strBlr.append(getIndentation()).append("}\n");

        } else
            throw new NullPointerException();
    }

    public void Visit(FormalParametersNode node) {
        if (node != null) {
            if (node.variables.size() > 0) {
                node.variables.forEach(param -> {
                    strBlr.append(", " + param + ": unknown");
                });
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(StatementNode node) {
        if (node != null) {
            if (node.declarationNode != null) {
                node.declarationNode.accept(this);
            } else if (node.controlStructNode != null) {
                node.controlStructNode.accept(this);
            } else if (node.functionCallNode != null) {
                node.functionCallNode.accept(this);
            } else if (node.procedureCallNode != null) {
                node.procedureCallNode.accept(this);
            } else if (node.terminal != null) {
                node.assignmentNode.accept(this);
            } else if (node.cellNode != null) {
                node.cellNode.accept(this);
            } else if (node.returnNode != null) {
                node.returnNode.accept(this);
            }

            // And what about the terminalNode?
            else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(DeclarationNode node) {
        if (node != null) {
            strBlr.append("let ").append(node.IdToken);
            if (node.assignmentNode != null) {
                strBlr.append(" = ");
                node.assignmentNode.accept(this);
            }
            strBlr.append("\n");
        } else
            throw new NullPointerException();
    }

    public void Visit(ControlStructNode node) {
        if (node != null) {
            if (node.iterativeStructNode != null) {
                if (node.iterativeStructNode.repeatStructNode != null) {
                    node.iterativeStructNode.repeatStructNode.accept(this);
                }
            } else if (node.selectiveStructNode != null) {
                if (node.selectiveStructNode.ifStructNode != null) {
                    node.selectiveStructNode.ifStructNode.accept(this);
                }
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(RepeatStructNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                //strBlr.append(getIndentation()).append("while (");
                strBlr.append("while (");
                node.expressionNode.accept(this);
                strBlr.append(") {\n");
                increaseIndent();
            }

            // Repeat while loop body
            if (node.statementNodes != null) {
                if (node.statementNodes.size() > 0) {
                    strBlr.append(getIndentation());
                    node.statementNodes.forEach(s -> {
                        s.accept(this);
                    });
                }
            }

            decreaseIndent();
            strBlr.append(getIndentation()).append("}\n");
        } else {
            throw new NullPointerException();
        }
    }

    public void Visit(IfStructNode node) {
        if (node != null) {
            if (node.ifConditionNode != null) {
                node.ifConditionNode.accept(this);
            }

            if (node.statementNodes != null) {
                increaseIndent();
                if (node.statementNodes.size() > 0) {
                    strBlr.append(getIndentation());
                    node.statementNodes.forEach(s -> {
                        s.accept(this);
                    });
                }
                decreaseIndent();
            }

            strBlr.append(getIndentation()).append("}\n");


            if (node.elseIfStructNodes != null) {
                if (node.elseIfStructNodes.size() > 0) {
                    node.elseIfStructNodes.forEach(s -> {
                        s.accept(this);
                    });
                }
            }

            if (node.elseStructNode != null) {
                strBlr.append(getIndentation());
                node.elseStructNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(IfConditionNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                strBlr.append("if (");
                node.expressionNode.accept(this);
                strBlr.append(") {\n");
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ElseIfStructNode node) {
        if (node != null) {
            strBlr.append(getIndentation());
            strBlr.append("else ");
            if (node.ifConditionNode != null) {
                node.ifConditionNode.accept(this);
            }

            increaseIndent();

            if (node.statementNodes != null) {
                if (node.statementNodes.size() > 0) {
                    strBlr.append(getIndentation());
                    node.statementNodes.forEach(s -> {
                        s.accept(this);
                    });
                }
            }
            decreaseIndent();
            strBlr.append(getIndentation()).append("}\n");
        } else throw new NullPointerException();
    }

    public void Visit(ElseStructNode node) {
        if (node != null) {
            strBlr.append("else {\n");

            increaseIndent();

            if (node.statementNode != null) {
                if (node.statementNode.size() > 0) {
                    strBlr.append(getIndentation());
                    node.statementNode.forEach(s -> {
                        if (s != null) {
                            s.accept(this);
                        }
                    });
                }
            }

            decreaseIndent();

            strBlr.append(getIndentation()).append("}\n");
        } else
            throw new NullPointerException();
    }

    public void Visit(ReturnNode node) {
        if (node != null) {
            strBlr.append("return ");
            if (node.expressionNode != null) {
                node.expressionNode.accept(this);
            }
            strBlr.append("\n");
        } else
            throw new NullPointerException();
    }

    public void Visit(AssignmentNode node) {
        if (node != null) {
            if (node.expressionNode != null) {
                node.expressionNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ExpressionNode node) {
        if (node != null) {
            if (node.parenExprNode != null) {
                node.parenExprNode.accept(this);
            } else if (node.unaryExprNode != null) {
                node.unaryExprNode.accept(this);
            } else if (node.infixExprNode != null) {
                node.infixExprNode.accept(this);
            } else if (node.valueExprNode != null) {
                node.valueExprNode.accept(this);
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(ParenExprNode node) {
        // Hackish char null check
        if (node != null) {
            if (node.leftPar != '\u0000' && node.expressionNode != null && node.rightPar != '\u0000') {
                strBlr.append(node.leftPar);
                node.expressionNode.accept(this);
                strBlr.append(node.rightPar);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(UnaryExprNode node) {
        if (node != null) {
            if (node.right != null && node.operator != null) {
                strBlr.append(node.operator);
                node.right.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(InfixExprNode node) {
        if (node != null) {
            if (node.left != null && node.operatorNode != null && node.right != null) {
                node.left.accept(this);
                node.operatorNode.accept(this);
                node.right.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ValueExprNode node) {
        if (node != null) {
            if (node.valueNode != null) {
                node.valueNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(ValueNode node) {
        if (node != null) {
            if (node.INUM != null) {
                strBlr.append(node.INUM);
            } else if (node.FLOAT != null) {
                strBlr.append(node.FLOAT);
            } else if (node.STRING != null) {
                strBlr.append(node.STRING);
            } else if (node.VARIABLE != null) {
                strBlr.append(node.VARIABLE);
            } else if (node.BOOLEAN != null) {
                strBlr.append(node.BOOLEAN);
            } else if (node.cellNode != null) {
                //strBlr.append(node.cellNode);
                node.cellNode.accept(this);
            } else if (node.functionCallNode != null) {
                strBlr.append(node.functionCallNode);
            } else if (node.procedureCallNode != null) {
                strBlr.append(node.procedureCallNode.PROCEDURE.toString() + "()");
            } else
                throw new NotImplementedError();

            if (node.methodNode != null) {
                //strBlr.append(node.methodNode);
                node.methodNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(CellNode node) {
        if (node != null) {

            if (node.SINGLE_CELL != null) {
                // strBlr.append(EelCelltoExcelCell(node.SINGLE_CELL));
            } else if (node.RANGE != null) {
                strBlr.append(node.RANGE);
            }

            if (node.CELL_METHOD != null) {
                if (Objects.equals(node.CELL_METHOD.toString(), ".value")) {
                    if (cellAccessor.get(node.SINGLE_CELL) != null) {
                        // Set Value
                        strBlr.append("workbook.getActiveWorksheet().getCell");
                        strBlr.append(EelCelltoExcelCell(node.SINGLE_CELL));
                        strBlr.append(".setValue(");
                        strBlr.append(cellAccessor.get(node.SINGLE_CELL));
                        strBlr.append(")\n");
                    } else {
                        // Get Value
                        strBlr.append("workbook.getActiveWorksheet().getCell")
                                .append(EelCelltoExcelCell(node.SINGLE_CELL))
                                .append(".getValue()\n");
                    }
                } else if (Objects.equals(node.CELL_METHOD.toString(), ".format")) {
                    if (cellAccessor.get(node.SINGLE_CELL) != null) {
                        String[] parts = cellAccessor.get(node.SINGLE_CELL).toString().replace("\"", "").split(":");
                        String key = parts[0];
                        String value = parts[1];

                        if (Objects.equals(key, "backgroundColor")) {
                            strBlr.append("workbook.getActiveWorksheet().getCell");
                            strBlr.append(EelCelltoExcelCell(node.SINGLE_CELL));
                            strBlr.append(".getFormat().getFill().setColor(\"");
                            strBlr.append(value);
                            strBlr.append("\")\n");
                        } else if (Objects.equals(key, "textColor")) {
                            strBlr.append("workbook.getActiveWorksheet().getCell");
                            strBlr.append(EelCelltoExcelCell(node.SINGLE_CELL));
                            strBlr.append(".getFormat().getFont().setColor(\"");
                            strBlr.append(value);
                            strBlr.append("\")\n");
                        }
                    }
                }
            }
        } else
            throw new NullPointerException();
    }


    public String EelCelltoExcelCell(TerminalNode n) {
        int x = 0, y = 0;
        int row = -1;
        int column = -1;

        if (n.toString().matches(".*[a-zA-Z].*")) {
            String cellRefWithoutParentheses = n.toString().replaceAll("[()]", "");
            StringBuilder columnLetters = new StringBuilder();
            StringBuilder rowNumbers = new StringBuilder();

            for (char ch : cellRefWithoutParentheses.toCharArray()) {
                if (Character.isLetter(ch)) {
                    columnLetters.append(ch);
                } else if (Character.isDigit(ch)) {
                    rowNumbers.append(ch);
                }
            }

            x = getColumnIndex(columnLetters.toString());
            y = Integer.parseInt(rowNumbers.toString()) - 1;
        } else {
            try {
                String[] parts = n.toString().substring(1, n.toString().length() - 1).split(",");
                x = Integer.parseInt(parts[0].trim()) - 1;
                y = Integer.parseInt(parts[1].trim()) - 1;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format");
            }
        }

        return "(" + x + ", " + y + ")";
    }

    private static int getColumnIndex(String letters) {
        int index = 0;
        int power = 1;

        for (int i = letters.length() - 1; i >= 0; i--) {
            char letter = letters.charAt(i);
            index += (letter - 'A' + 1) * power;
            power *= 26;
        }

        return index - 1;
    }


    public void Visit(FunctionCallNode node) {
        if (node != null) {
            // Check for "print" and rewrite to "console.log"
            if (Objects.equals(node.FUNCTIONS.toString(), "print")) {
                strBlr.append("console.log(");
            } else {
                strBlr.append(node.FUNCTIONS).append("([");
            }
            if (node.actualParamsNode != null) {
                node.actualParamsNode.accept(this);
            }
            if (Objects.equals(node.FUNCTIONS.toString(), "print")) {
                strBlr.append(")\n");
            } else {
                strBlr.append("])\n");
            }
        } else
            throw new NullPointerException();
    }


    public void Visit(ProcedureCallNode node) {
        if (node != null) {
            strBlr.append(node.PROCEDURE + "(");
            if (node.actualParamsNode != null) {
                node.actualParamsNode.accept(this);
            }
            strBlr.append(")\n");
        } else
            throw new NullPointerException();
    }


    public void Visit(MethodNode node) {
        if (node != null) {
            strBlr.append(node.METHODS.toString() + "(");
            if (node.actualParamsNode != null) {
                node.actualParamsNode.accept(this);
            }
            strBlr.append(")");

            if (node.methodNode != null) {
                node.methodNode.accept(this);
            }
        } else
            throw new NullPointerException();
    }


    public void Visit(ActualParamsNode node) {
        if (node != null) {
            if (node.valuesNodes.size() > 0) {
                boolean isFirstValue = true;
                for (ValueNode value : node.valuesNodes) {
                    if (isFirstValue) {
                        value.accept(this);
                        isFirstValue = false;
                    } else {
                        strBlr.append(", ");
                        value.accept(this);
                    }
                }
            }
        } else
            throw new NullPointerException();
    }


    public void Visit(OperatorNode node) {
        if (node != null) {
            if (node.binaryOperatorNode != null) {
                node.binaryOperatorNode.accept(this);
            } else if (node.booleanOperatorNode != null) {
                node.booleanOperatorNode.accept(this);
            } else
                throw new NotImplementedError();
        } else
            throw new NullPointerException();
    }

    public void Visit(BinaryOperatorNode node) {
        if (node != null) {
            if (node.binaryOperator != null) {
                strBlr.append(node.binaryOperator);
            }
        } else
            throw new NullPointerException();
    }

    public void Visit(BooleanOperatorNode node) {
        if (node != null) {
            if (node.booleanOperator != null) {
                strBlr.append(node.booleanOperator);
            }
        } else
            throw new NullPointerException();
    }

    @Override
    public void defaultVisit(Object o) {

    }

    // Helper methods to manage indentation level
    private int indentLevel = 0;
    private static final int SPACES_PER_INDENT = 4;

    private void increaseIndent() {
        indentLevel++;
    }

    private void decreaseIndent() {
        if (indentLevel > 0) {
            indentLevel--;
        }
    }

    private String getIndentation() {
        return " ".repeat(indentLevel * SPACES_PER_INDENT);
    }

}
