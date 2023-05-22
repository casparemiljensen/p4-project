import com.eel.AST.nodes.FormalParametersNode;
import com.eel.AST.nodes.ProcedureDeclarationNode;
import com.eel.AST.nodes.ProcedureNode;
import com.eel.AST.nodes.ProgramNode;
import com.eel.Generator;
import com.eel.errors.Errors;
import com.eel.errors.Item;
import com.eel.parsing.BuildSymbolTableVisitor;
import com.eel.parsing.SymbolTable;
import com.eel.parsing.TypeCheckVisitor;
import com.eel.parsing.VariableDeclarationVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CodeGenerationTest {
    @Test
    public void CodeIsGenerated() throws IOException {
        TerminalNode terminalNode = new TerminalNodeImpl(new TestToken("Main", 0));
        FormalParametersNode formalParametersNode = new FormalParametersNode(0,0, new ArrayList<>());
        ProcedureDeclarationNode procedureDeclarationNode = new ProcedureDeclarationNode(0,0, terminalNode, formalParametersNode);

        ProcedureNode procedureNode = new ProcedureNode(0,0, procedureDeclarationNode, new ArrayList<>());

        ArrayList<ProcedureNode> procedureNodes = new ArrayList<>();
        procedureNodes.add(procedureNode);

        ProgramNode programNode = new ProgramNode(0, 0, procedureNodes);

        // Test symbol table
        Errors symbolTableErrors = new Errors();
        SymbolTable symbolTable = new SymbolTable();
        BuildSymbolTableVisitor buildSymbolTableVisitor = new BuildSymbolTableVisitor(symbolTable, symbolTableErrors);
        buildSymbolTableVisitor.performVisit(programNode);

        assert(!symbolTableErrors.containsErrors());

        // Test variable declarations
        Errors varDclErrors = new Errors();
        VariableDeclarationVisitor varDclVisitor = new VariableDeclarationVisitor(symbolTable, varDclErrors);
        varDclVisitor.performVisit(programNode);

        assert(!varDclErrors.containsErrors());

        // Test type check
        Errors typeCheckErrors = new Errors();
        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable, typeCheckErrors);
        typeCheckVisitor.performVisit(programNode);

        assert(!typeCheckErrors.containsErrors());

        // Test code generation
        Generator generator = new Generator();
        generator.performVisit(programNode);

        assertEquals("Files are not identical", FileUtils.readFileToString(new File("tests/test.ts")), FileUtils.readFileToString(new File("out/production/eel/com/eel/OutputCode.ts")));
    }
}
