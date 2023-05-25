package com.eel;

import com.eel.helpers.ASTPrinter;
import com.eel.AST.BuildASTVisitor;
import com.eel.AST.nodes.ProgramNode;
import com.eel.antlr.*;
import com.eel.errors.Errors;
import com.eel.errors.Item;
import com.eel.semantic.SymbolTable;
import com.eel.semantic.BuildSymbolTableVisitor;
import com.eel.semantic.TypeCheckVisitor;
import com.eel.helpers.SymbolTablePrinter;
import com.eel.semantic.VariableDeclarationVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.*;

class Eel {
    public static void main(String[] args) throws Exception {
        Errors symbolTableErrors = new Errors();
        Errors typeCheckErrors = new Errors();
        Errors varDclErrors = new Errors();
        SymbolTable symbolTable = new SymbolTable();

        var inputStream = CharStreams.fromString(readFileAsString("out/production/eel/program.eel"));

        eelLexer lexer = new eelLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        eelParser parser = new eelParser(tokens);

        ParseTree cst = parser.program();
        var ast = (ProgramNode) new BuildASTVisitor().visit(cst);
        ASTPrinter astPrinter = new ASTPrinter();
        astPrinter.print(ast);
        System.out.println();
        BuildSymbolTableVisitor buildSymbolTableVisitor = new BuildSymbolTableVisitor(symbolTable, symbolTableErrors);
        buildSymbolTableVisitor.performVisit(ast);

        if (!symbolTableErrors.containsErrors()) {
            VariableDeclarationVisitor varDclVisitor = new VariableDeclarationVisitor(symbolTable, varDclErrors);
            varDclVisitor.performVisit(ast);

            if (!varDclErrors.containsErrors()) {
                TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable, typeCheckErrors);
                typeCheckVisitor.performVisit(ast);

                System.out.println();
                System.out.println("       [--- Symbol Table - After TypeCheck --- ]");
                SymbolTablePrinter symbolTablePrinter = new SymbolTablePrinter();
                symbolTablePrinter.printSymbolTable(symbolTable);

                if (!typeCheckErrors.containsErrors()) {
                    System.out.println("----------------TS----------------");
                    Generator generator = new Generator();
                    generator.performVisit(ast);
                } else {
                    System.out.println("[ -- ERRORS -- ]");
                    System.out.println("[TypeCheck] Code contains " + typeCheckErrors.errors.stream().count() + " errors:");
                    printErrors(typeCheckErrors);
                }
            } else {
                System.out.println("[ -- ERRORS -- ]");
                System.out.println("[VarDcl] Code contains " + varDclErrors.errors.stream().count() + " errors:");
                printErrors(varDclErrors);
            }
        } else {
            System.out.println("[ -- ERRORS -- ]");
            System.out.println("[SymbolTable] Code contains " + symbolTableErrors.errors.stream().count() + " errors:");
            printErrors(symbolTableErrors);
        }
    }

    public static void printErrors(Errors errors) {
        for (Item error : errors.errors) {
            System.out.println(error.type.toString() + ": " + error.message + " (" + error.type.name() + ")" + " on line: " + error.lineNumber + ", column " + error.column);

            //Enters if the error message is on multiple lines
            if (error.lines.size() > 0) {
                //Creates spaces, so the lines are aligned
                String indent = " ".repeat(error.type.toString().length());

                for (String line : error.lines) {
                    //Enters if line contains other characters than just spaces
                    if (line.trim().length() > 0) {
                        System.out.println(indent + "| " + line);
                    }
                }

                System.out.println();
            }
        }
    }

    public static String readFileAsString(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
