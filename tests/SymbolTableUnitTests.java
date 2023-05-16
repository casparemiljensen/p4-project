import com.eel.AST.nodes.*;
import com.eel.errors.Errors;
import com.eel.parsing.SymbolTable;
import com.eel.parsing.SymbolTableVisitor;
import kotlin.NotImplementedError;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class SymbolTableUnitTests {
    @Test
    public void GeneratesErrorForDuplicateFunctionNames() {
        TerminalNode terminalNode = new TerminalNodeImpl(new TestToken("main", 0));
        ProcedureNode procedureNode = new ProcedureNode(0,0, terminalNode, new ArrayList<>());
        ProcedureNode procedureNode2 = new ProcedureNode(0,0, terminalNode, new ArrayList<>());

        ArrayList<ProcedureNode> procedureNodes = new ArrayList<>();
        procedureNodes.add(procedureNode);
        procedureNodes.add(procedureNode2);

        ProgramNode programNode = new ProgramNode(0, 0, procedureNodes);

        SymbolTable table = new SymbolTable();
        Errors errors = new Errors();
        SymbolTableVisitor visitor = new SymbolTableVisitor(table, errors);

        visitor.Visit(programNode);

        assert(errors.containsErrors());
    }
    @Test
    public void ProcedureMustImplementOneStatement() {
        //Token token = new CommonToken(0, "main");
        TerminalNode terminalNode = new TerminalNodeImpl(new TestToken("test", 0));

        NotImplementedError exception = assertThrows(NotImplementedError.class, ()->{
            StatementNode statementNode = new StatementNode(0,0, null, terminalNode);

            ArrayList<StatementNode> statementNodes = new ArrayList<>();
            statementNodes.add(statementNode);

            ProcedureNode procedureNode = new ProcedureNode(0,0, terminalNode, statementNodes);

            ArrayList<ProcedureNode> procedureNodes = new ArrayList<>();
            procedureNodes.add(procedureNode);

            ProgramNode programNode = new ProgramNode(0, 0, procedureNodes);

            SymbolTable table = new SymbolTable();
            Errors errors = new Errors();
            SymbolTableVisitor visitor = new SymbolTableVisitor(table, errors);

            visitor.Visit(programNode);
        });

        assertTrue(exception.getMessage().contentEquals("An operation is not implemented.")); //TODO: This exception message probably should be something else.
    }
}
