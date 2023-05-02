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


        // The error was that we called visit(parser.prog()) but instead we should call tree....
        // Apparently is does not work even though we follow robocode's method...
        ParseTree cst = parser.prog();

        var ast = (ProgNode) new BuildIfStmtVisitor().visit(cst);

//      var value = new EvaluateIfStmtVisitor().Visit(ast);
        PrintAst printAst = new PrintAst();
        printAst.Visit(ast);
    }

//    public static String printSyntaxTree(Parser parser, ParseTree root) {
//        StringBuilder buf = new StringBuilder();
//        recursive(root, buf, 0, Arrays.asList(parser.getRuleNames()));
//        return buf.toString();
//    }
//
//    private static void recursive(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
//        for (int i = 0; i < offset; i++) {
//            buf.append("  ");
//        }
//        buf.append(Trees.getNodeText(aRoot, ruleNames)).append("\n");
//        if (aRoot instanceof ParserRuleContext) {
//            ParserRuleContext prc = (ParserRuleContext) aRoot;
//            if (prc.children != null) {
//                for (ParseTree child : prc.children) {
//                    recursive(child, buf, offset + 1, ruleNames);
//                }
//            }
//        }
//    }

    public static String readFileAsString(String fileName) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
