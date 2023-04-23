package com.eel;

import com.eel.antlr.eelLexer;
import com.eel.antlr.eelParser;
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

        eelListener listener = new eelListener();

        ParseTree tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);
    }

    public static String readFileAsString(String fileName) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
