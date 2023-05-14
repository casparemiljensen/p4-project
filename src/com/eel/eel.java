package com.eel;

import com.eel.AST.ASTPrinter;
import com.eel.AST.BuildASTVisitor;
import com.eel.AST.nodes.ProgramNode;
import com.eel.antlr.*;
import com.eel.errors.Errors;
import com.eel.errors.Item;
import com.eel.parsing.SymbolTable;
//import com.eel.parsing.SymbolTableVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.*;

class Eel {
	public static void main(String[] args) throws Exception {
		Errors errors = new Errors();
		var inputStream = CharStreams.fromString(readFileAsString("out/production/eel/program.txt"));

		eelLexer lexer = new eelLexer(inputStream);
		var tokens = new CommonTokenStream(lexer);
		eelParser parser = new eelParser(tokens);

		ParseTree cst = parser.program();
		var ast = (ProgramNode) new BuildASTVisitor().visit(cst);
		ASTPrinter astPrinter = new ASTPrinter();
		astPrinter.print(ast);

		System.out.println();
		System.out.println();
		System.out.println("Look at this pretty OfficeScript code!");
		System.out.println();
//		SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(new SymbolTable(), errors);
//		symbolTableVisitor.performVisit(ast);
//
//		if (!errors.containsErrors()) {
//			Generator generator = new Generator();
//			generator.performVisit(ast);
//		} else {
//			System.out.println("Code contains " + errors.errors.stream().count() + " errors:");
//			for (Item error : errors.errors) {
//				System.out.println(error.type.toString()+": "+error.message+" ("+error.type.name()+")" +
//							(error.lineNumber > 0 ? " on line "+error.lineNumber : ""));
//
//				//Enters if the error message is on multiple lines
//				if (error.lines.size() > 0) {
//					//Creates spaces, so the lines are aligned
//					String indent = " ".repeat(error.type.toString().length());
//
//					for (String line : error.lines) {
//						//Enters if line contains other characters than just spaces
//						if (line.trim().length() > 0) {
//							System.out.println(indent + "| " + line);
//						}
//					}
//					System.out.println();
//				}
//			}
//		}


	}

	public static String readFileAsString(String fileName) throws Exception {
		return new String(Files.readAllBytes(Paths.get(fileName)));
	}
}
