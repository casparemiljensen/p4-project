package com.eel;

import com.eel.AST.nodes.AstVisitor;
import com.eel.AST.nodes.*;

import java.util.Objects;

public class Compiler extends AstVisitor<String> {
	@Override
	public String Visit(ProgramNode node, int instructionCode) {
        if(node == null)
            return null;

		for (ProcedureNode procedureNode : node.procedureNodes) {
			Visit(procedureNode, instructionCode);
		}

		return null;
	}

	@Override
	public String Visit(ProcedureNode node, int instructionCode) {
        if(node == null)
            return null;

        if(instructionCode == 1)
            System.out.println("function " + node.idToken + "(workbook: ExcelScript.Workbook)\n{");

		for (StatementNode statementNode : node.statementNodes) {
			if (node != null) {
				Visit(statementNode, instructionCode);
			}
		}

        if(instructionCode == 1)
            System.out.println("}");

		return null;
	}

	@Override
	public String Visit(FormalParametersNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(DeclarationNode node, int instructionCode) {
        System.out.println("let " + node.IdToken);

		return null;
	}

	@Override
	public String Visit(StatementNode node, int instructionCode) {
		if (node == null)
			return null;

        if(node.declarationNode != null) {
            if (node.declarationNode.assignmentNode.expressionNode.valueNode != null) {
                if (node.declarationNode.assignmentNode.expressionNode.valueNode.staticValueNode != null) {
                    if (node.declarationNode.assignmentNode.expressionNode.valueNode.staticValueNode.INUM != null) {
                        System.out.println("    let " + node.declarationNode.IdToken + " = " + node.declarationNode.assignmentNode.expressionNode.valueNode.staticValueNode.INUM);
                    }
                    if (node.declarationNode.assignmentNode.expressionNode.valueNode.staticValueNode.STRING != null) {
                        System.out.println("    let " + node.declarationNode.IdToken + " = " + node.declarationNode.assignmentNode.expressionNode.valueNode.staticValueNode.STRING);
                    }
                }
            }
        }

        if(node.controlStructNode != null) {
            if(node.controlStructNode.selectiveStructNode.ifStructNode != null) {
                var left = node.controlStructNode.selectiveStructNode.ifStructNode.ifConditionNode.expressionNode.left.valueNode.staticValueNode.INUM;
                var operator = "+";
                var right = node.controlStructNode.selectiveStructNode.ifStructNode.ifConditionNode.expressionNode.right.valueNode.staticValueNode.INUM;

                System.out.println("    if(" + left + operator + right + ") {");

                for (StatementNode statementNode : node.controlStructNode.selectiveStructNode.ifStructNode.statementNodes) {
                    Visit(statementNode, instructionCode);
                }

                for (ElseIfStructNode elseIfStructNode : node.controlStructNode.selectiveStructNode.ifStructNode.elseIfStructNodes) {
                    if (elseIfStructNode != null) {
                        var elseLeft = elseIfStructNode.ifConditionNode.expressionNode.left.valueNode.staticValueNode.INUM;
                        var elseOperator = "+"; //elseIfStructNode.ifConditionNode.expressionNode.operatorNode.toString();
                        var elseRight = elseIfStructNode.ifConditionNode.expressionNode.right.valueNode.staticValueNode.INUM;
                        System.out.println("    } elseif(" + elseLeft + elseOperator + elseRight + ") { ");

						for (StatementNode statementNode : elseIfStructNode.statementNodes) {
							Visit(statementNode, instructionCode);
						}
                    }
                }

				if(node.controlStructNode.selectiveStructNode.ifStructNode.elseStructNode != null) {
					System.out.println("	} else {");
					for (StatementNode statementNode : node.controlStructNode.selectiveStructNode.ifStructNode.elseStructNode.statementNode) {
						Visit(statementNode, instructionCode);
					}
				}

                System.out.println("    }");
            }
        }

        if(node.expressionNode != null) {
            if(node.expressionNode.valueNode.staticValueNode.functionNode.FUNCTION != null) {
                if(Objects.equals(node.expressionNode.valueNode.staticValueNode.functionNode.FUNCTION.toString(), "print")) {
					// INUM
					System.out.println("	console.log(\"" + node.expressionNode.valueNode.staticValueNode.functionNode.actualParamsNode.valuesNodes + "\")");
					// STRING
					System.out.println("	console.log(\"" + node.expressionNode.valueNode.staticValueNode.functionNode.actualParamsNode.valuesNodes + "\")");
                }
            }
        }

		return null;
	}

	@Override
	public String Visit(ExpressionNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(OperatorNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(BinaryOperatorNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(BooleanOperatorNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(ControlStructNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(IterativeStructNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(SelectiveStructNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(IfStructNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(IfConditionNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(ElseIfStructNode node, int instructionCode) {
		return null;
	}

	@Override
	public String Visit(ElseStructNode node, int instructionCode) {
		return null;
	}
}
