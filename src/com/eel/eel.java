package com.eel;

import com.eel.eelLexer;
import com.eel.eelParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

class eelApp {
    public static void main(String[] args)
    {
        eelLexer lexer = new eelLexer(CharStreams.fromString(
                "begin main()" +
                        "let test = 5" +
                        "let test2 = 10" +
                        "test3 = test + test" +
                        "endProcedure"
        ));
        eelParser parser = new eelParser(new CommonTokenStream(lexer));

        System.out.println("Hello World");
    }
}
