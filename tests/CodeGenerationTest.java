import com.eel.AST.BuildASTVisitor;
import com.eel.AST.nodes.ProcedureNode;
import com.eel.AST.nodes.ProgramNode;
import com.eel.Generator;
import com.eel.antlr.eelLexer;
import com.eel.antlr.eelParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

import java.util.ArrayList;

public class CodeGenerationTest {
    @Test
    public void CodeIsGenerated() throws IOException {
        TerminalNode terminalNode = new TerminalNodeImpl(new TestToken("main", 0));
        ProcedureNode procedureNode = new ProcedureNode(0,0, terminalNode, new ArrayList<>());
        ProcedureNode procedureNode2 = new ProcedureNode(0,0, terminalNode, new ArrayList<>());

        ArrayList<ProcedureNode> procedureNodes = new ArrayList<>();
        procedureNodes.add(procedureNode);

        ProgramNode programNode = new ProgramNode(0, 0, procedureNodes);

        var inputStream = CharStreams.fromPath(Paths.get("out/production/eel/program.txt"));

        eelLexer lexer = new eelLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        eelParser parser = new eelParser(tokens);

        ParseTree cst = parser.program();
        var ast = (ProgramNode) new BuildASTVisitor().visit(cst);

        Generator officeScriptsCG = new Generator();
        officeScriptsCG.performVisit(ast);

        assert(true); //TODO: When cg isn't console output, check it here
    }
}
