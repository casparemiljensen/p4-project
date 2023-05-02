package com.eel;

import com.eel.AST.BuildASTVisitor;
import com.eel.AST.PrintAst;
import com.eel.AST.nodes.ProgNode;
import com.eel.antlr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.*;

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
        var ast = (ProgNode) new BuildASTVisitor().visit(cst);
//      var value = new EvaluateIfStmtVisitor().Visit(ast);
        PrintAst printAst = new PrintAst();
        printAst.Visit(ast);
    }

    public static String readFileAsString(String fileName) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
