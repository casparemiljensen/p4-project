package com.eel;

import com.eel.AST.ASTPrinter;
import com.eel.AST.BuildASTVisitor;
import com.eel.AST.nodes.ProgramNode;
import com.eel.antlr.*;
import com.eel.errors.Errors;
import com.eel.errors.Item;
import com.eel.parsing.SymbolTable;
import com.eel.parsing.BuildSymbolTableVisitor;
import com.eel.parsing.SemanticVisitor;
import com.eel.parsing.SymbolTablePrinter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.jetbrains.annotations.Nullable;

import java.nio.file.*;

class Eel {
	public static void main(String[] args) throws Exception {
		Errors symbolTableErrors = new Errors();
		Errors semanticErrors = new Errors();
		SymbolTable symbolTable = new SymbolTable();

		var inputStream = CharStreams.fromString(readFileAsString("out/production/eel/program.txt"));

		eelLexer lexer = new eelLexer(inputStream);
		var tokens = new CommonTokenStream(lexer);
		eelParser parser = new eelParser(tokens);

		ParseTree cst = parser.program();
		var ast = (ProgramNode) new BuildASTVisitor().visit(cst);
		ASTPrinter astPrinter = new ASTPrinter();
		astPrinter.print(ast);

		BuildSymbolTableVisitor buildSymbolTableVisitor = new BuildSymbolTableVisitor(symbolTable, symbolTableErrors);
		buildSymbolTableVisitor.performVisit(ast);

		SymbolTablePrinter symbolTablePrinter = new SymbolTablePrinter();
		symbolTablePrinter.printSymbolTable(symbolTable);

		if(!symbolTableErrors.containsErrors()) {


			SemanticVisitor semanticVisitor =  new SemanticVisitor(symbolTable, semanticErrors);
			semanticVisitor.performVisit(ast);

			if (!semanticErrors.containsErrors()) {
				Generator generator = new Generator();
				generator.performVisit(ast);
			}
		}
		else {
			System.out.println("[SymbolTable] Code contains " + symbolTableErrors.errors.stream().count() + " errors:");
			System.out.println("[TypeCheck] Code contains " + semanticErrors.errors.stream().count() + " errors:");
			printErrors(symbolTableErrors);
			printErrors(semanticErrors);
		}
	}

	public static void printErrors(Errors errors) {
		for (Item error : errors.errors) {
			System.out.println(error.type.toString()+": "+error.message+" ("+error.type.name()+")" + "on line: " + error.lineNumber + ", column " + error.column);

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
