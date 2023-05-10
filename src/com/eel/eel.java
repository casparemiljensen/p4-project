package com.eel;

import com.eel.AST.*;
import com.eel.AST.ReflectiveASTVisitor;
import com.eel.AST.nodes.ProgramNode;
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

        ParseTree cst = parser.program();
        var ast = (ProgramNode) new BuildASTVisitor().visit(cst);
        ASTPrinter astPrinter = new ASTPrinter();
        astPrinter.print(ast);

        ReflectiveASTVisitor visitor = new EvaluateASTVisitor();
        visitor.performVisit(ast);

    }

    public static String readFileAsString(String fileName) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
