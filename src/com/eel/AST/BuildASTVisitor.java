package com.eel.AST;

import com.eel.AST.nodes.*;
import com.eel.antlr.eelBaseVisitor;
import com.eel.antlr.eelParser;
import com.eel.antlr.eelVisitor;
import kotlin.NotImplementedError;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildASTVisitor extends eelBaseVisitor<AbstractNode> implements eelVisitor<AbstractNode> {

    @Override
    public ProgramNode visitProgram(eelParser.ProgramContext ctx) {
        List<ProcedureNode> procedures = CreateList(ctx.procedure(), ProcedureNode.class);
        return new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), procedures);
    }

    @Override
    public ProcedureNode visitProcedure(eelParser.ProcedureContext ctx) {
        List<StatementNode> statementNodes = CreateList(ctx.statement(), StatementNode.class);
        return new ProcedureNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID(), ((ctx.formalParams() != null) ? visitFormalParams(ctx.formalParams()) : null), statementNodes);
    }

    @Override
    public FormalParametersNode visitFormalParams(eelParser.FormalParamsContext ctx) {
        return new FormalParametersNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID());
    }

    @Override
    public AbstractNode visitStatement(eelParser.StatementContext ctx) {
        AbstractNode node = null;
        if (ctx.declaration() != null) {
            node = visit(ctx.declaration());
        } else if (ctx.controlStruct() != null) {
            node = visit(ctx.controlStruct());
        } else if (ctx.return_() != null) {
            node = visit(ctx.return_());
        }

        return new StatementNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine(), node
        );
    }

    @Override
    public DeclarationNode visitDeclaration(eelParser.DeclarationContext ctx) {
        return new DeclarationNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "let", ctx.ID(), visitAssignment(ctx.assignment()));
    }

    @Override
    public AssignmentNode visitAssignment(eelParser.AssignmentContext ctx) {
        return new AssignmentNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "assign", visitExpression(ctx.expression()));
    }


    public AbstractNode visitExpressionNode(eelParser.ExpressionContext ctx) {
        AbstractNode node = null;
        if (ctx instanceof eelParser.ParenExprContext) {
//             node = visit(eelParser.ParenExprContext);
        } else if (ctx instanceof eelParser.UnaryExprContext) {
//             node = visit(eelParser.UnaryExprContext);
        } else if (ctx instanceof eelParser.InfixExprContext) {
//                node = visit(ctx.return_());
        } else if (ctx instanceof eelParser.ValueExprContext) {
//            lol
    } else {
        throw new NotImplementedError();
    }
            return new StatementNode(
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(), node
            );
}



    @Override
    public UnaryExpressionNode visitUnaryExpressionNode(eelParser.UnaryExprContext ctx) {
//        return new UnaryExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitOperator(ctx.expression().));
    }


    @Override
    public InfixExpressionNode visitInfixExpressionNode (eelParser.InfixExprContext ctx) {

    }




//    public ExpressionNode visitExpression(eelParser.ExpressionContext ctx) {
//        ExpressionNode node = null;
//        if (ctx == null) return null;
//            // expr op expr
//        else if (ctx.left != null) {
//
//            // Infix
//            if (ctx.operator().binaryOperator() != null) {
//                System.out.println(ctx.operator().binaryOperator().BINARYOP().getText());
//
//                switch (ctx.operator().binaryOperator().BINARYOP().getText()) {
//                    case "+":
//                    case "-": {
//                        node = new AddSubNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().binaryOperator().BINARYOP(),visitExpression(ctx.right));
//                        break;
//                    }
//                    case "*":
//                    case "/": {
//                        node = new MultDivNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().binaryOperator().BINARYOP() ,visitExpression(ctx.right));
//                        break;
//                    }
//                    default:
//                        throw new NotImplementedError();
//                }
//
//
//            } else if (ctx.operator().booleanOperator() != null) {
//
//                // Unary
//                switch (ctx.operator().booleanOperator().BOOLEANOP().getText()) {
//                    case "<":
//                        node = new LessThanNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    case ">":
//                        node = new GreaterThanNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    case "<=":
//                        node = new LessThanOrEqualNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    case ">=":
//                        node = new GreaterThanOrEqualNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    case "==":
//                        node = new EqualsNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    case "!=":
//                        node = new NotEqualNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), ctx.operator().booleanOperator().BOOLEANOP(), visitExpression(ctx.right));
//                        break;
//                    default:
//                        throw new NotImplementedError();
//                }
//
//                return node;
////            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.left), visitOperator(ctx.operator()), visitExpression(ctx.right));
//                // '-' expr
//            }
//        }
//        else if (ctx.value() == null)
//            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "-", visitExpression(ctx.expression(0)));
//            // value
//        else
//            return new ExpressionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitValue(ctx.value()));
//        return node;
//    }
//    }

    @Override
    public ValueNode visitValue(eelParser.ValueContext ctx) {
        // staticValue
        if (ctx.userValue() == null)
            return new ValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitStaticValue(ctx.staticValue()));
            // userValue
        else
            return new ValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitUserValue(ctx.userValue()));
    }

    @Override
    public UserValueNode visitUserValue(eelParser.UserValueContext ctx) {
        return new UserValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID(), (ctx.actualParams() != null) ? visitActualParams(ctx.actualParams()) : null);
    }


    @Override
    public StaticValueNode visitStaticValue(eelParser.StaticValueContext ctx) {
        // INUM or STRING
        if (ctx.function() == null)
            return new StaticValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.INUM(), ctx.STRING(), ((ctx.method() != null) ? visitMethod(ctx.method()) : null));
            // function
        else
            return new StaticValueNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitFunction(ctx.function()), ((ctx.method() != null) ? visitMethod(ctx.method()) : null));
    }

    @Override
    public MethodNode visitMethod(eelParser.MethodContext ctx) {
        return new MethodNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.METHODS(), (ctx.actualParams() != null) ? visitActualParams(ctx.actualParams()) : null, ((ctx.method() != null) ? visitMethod(ctx.method()) : null));
    }

    @Override
    public FunctionNode visitFunction(eelParser.FunctionContext ctx) {
        return new FunctionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.FUNCTIONS(), (ctx.actualParams() != null) ? visitActualParams(ctx.actualParams()) : null);
    }

    @Override
    public ActualParamsNode visitActualParams(eelParser.ActualParamsContext ctx) {

        List<ValueNode> valueNodes = new ArrayList<>();
        for (eelParser.ValueContext child : ctx.value()) {
            valueNodes.add(visitValue(child));
        }
        return new ActualParamsNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), valueNodes);
    }

    @Override
    public ControlStructNode visitControlStruct(eelParser.ControlStructContext ctx) {
        // selectiveStruct
        if (ctx.iterativeStruct() == null)
            return new ControlStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitSelectiveStruct(ctx.selectiveStruct()));
            // iterativeStruct
        else
            return new ControlStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIterativeStruct(ctx.iterativeStruct()));
    }

    @Override
    public SelectiveStructNode visitSelectiveStruct(eelParser.SelectiveStructContext ctx) {
        return new SelectiveStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfStruct(ctx.ifStruct()));
    }

    @Override
    public ReturnNode visitReturn(eelParser.ReturnContext ctx) {
        return new ReturnNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "return", visitExpression(ctx.expression()));
    }

    @Override
    public OperatorNode visitOperator(eelParser.OperatorContext ctx) {
        AbstractNode node = null;
        if (ctx.binaryOperator() != null) {
            node = visitBinaryOperator(ctx.binaryOperator());
        } else if (ctx.booleanOperator() != null) {
            node = visitBooleanOperator(ctx.booleanOperator());
        } else if (ctx.ASSIGNMENT() != null) {
            return new OperatorNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ASSIGNMENT());
        }
        return new OperatorNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), node);
    }

    @Override
    public BooleanOperatorNode visitBooleanOperator(eelParser.BooleanOperatorContext ctx) {
        return new BooleanOperatorNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.BOOLEANOP());
    }

    @Override
    public BinaryOperatorNode visitBinaryOperator(eelParser.BinaryOperatorContext ctx) {
        return new BinaryOperatorNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.BINARYOP());
    }


    @Override
    public IfStructNode visitIfStruct(eelParser.IfStructContext ctx) {
        List<ParseTree> input2 = ctx.children.stream().filter(e -> e instanceof eelParser.StatementContext).collect(Collectors.toList());
        List<StatementNode> statements = CreateList(input2, StatementNode.class);
        List<ParseTree> input1 = ctx.children.stream().filter(e -> e instanceof eelParser.ElseIfStructContext).collect(Collectors.toList());
        List<ElseIfStructNode> ElseIfStructNodes = CreateList(input1, ElseIfStructNode.class);
        return new IfStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCondition(ctx.ifCondition()), "then", statements, ElseIfStructNodes, (ctx.elseStruct() != null) ? visitElseStruct(ctx.elseStruct()) : null);
    }

    @Override
    public IfConditionNode visitIfCondition(eelParser.IfConditionContext ctx) {
        return new IfConditionNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "if", visitExpression(ctx.expression()));
    }

    @Override
    public ElseIfStructNode visitElseIfStruct(eelParser.ElseIfStructContext ctx) {
        List<eelParser.StatementContext> input = ctx.statement();
        List<StatementNode> statements = CreateList(input, StatementNode.class);
        return new ElseIfStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitIfCondition(ctx.ifCondition()), statements);
    }

    @Override
    public ElseStructNode visitElseStruct(eelParser.ElseStructContext ctx) {
        List<ParseTree> input = ctx.children;
        List<StatementNode> statements = CreateList(input, StatementNode.class);
        return new ElseStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), statements);
    }


    @Override
    public IterativeStructNode visitIterativeStruct(eelParser.IterativeStructContext ctx) {
        return new IterativeStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitRepeatStruct(ctx.repeatStruct()));
    }

    @Override
    public RepeatStructNode visitRepeatStruct(eelParser.RepeatStructContext ctx) {
        List<StatementNode> statements = CreateList(ctx.statement(), StatementNode.class);
        return new RepeatStructNode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), visitExpression(ctx.expression()), statements);
    }

    private static <T> Collection<T> nullSafe(Collection<T> c) {
        return (c == null) ? Collections.<T>emptyList() : c;
    }

    private <T1, T2> List<T2> CreateList(Collection<T1> list, Class<T2> type) {
        List<T2> result = new ArrayList<T2>();
        for (T1 child : nullSafe(list)) {
            result.add(type.cast(visit((ParseTree) child)));
        }
        return result;
    }
}