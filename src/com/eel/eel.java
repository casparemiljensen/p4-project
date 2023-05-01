package com.eel;

import com.eel.antlr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

class Eel {
    public static void main(String[] args) throws Exception
    {
        var inputStream = CharStreams.fromString(readFileAsString("out/production/eel/program.txt"));

        eelLexer lexer = new eelLexer(inputStream);

        var tokens = new CommonTokenStream(lexer);
        eelParser parser = new eelParser(tokens);

        ParseTree tree = parser.prog();

//        AbstractNode root = (AbstractNode) parser.prog();
//        root.walkTree(new PrintTree(System.out));


        IfStmtVisitor ifStmtVisitor = new IfStmtVisitor(parser);
        var name = ifStmtVisitor.visit(parser.selCtrlStrc());
        System.out.print(name);


//        List<AST> astList = new EelBuildASTVisitor(parser).visit(tree).getChildren();
//
//        for (AST ast : astList) {
//            System.out.println(ast.toStringTree());
//        }
    }

    public static String printSyntaxTree(Parser parser, ParseTree root) {
        StringBuilder buf = new StringBuilder();
        recursive(root, buf, 0, Arrays.asList(parser.getRuleNames()));
        return buf.toString();
    }

    private static void recursive(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
        for (int i = 0; i < offset; i++) {
            buf.append("  ");
        }
        buf.append(Trees.getNodeText(aRoot, ruleNames)).append("\n");
        if (aRoot instanceof ParserRuleContext) {
            ParserRuleContext prc = (ParserRuleContext) aRoot;
            if (prc.children != null) {
                for (ParseTree child : prc.children) {
                    recursive(child, buf, offset + 1, ruleNames);
                }
            }
        }
    }

    public static String readFileAsString(String fileName) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
