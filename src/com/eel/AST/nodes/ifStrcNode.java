package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ifStrcNode extends AbstractNode {

    public ifCondNode ifCondNode;
    public String thenToken;
    public LinesNode lines;
    @Nullable
    public List<elseIfStrcNode> elseIfStrcNodes;
    @Nullable
    public elseStrcNode elseStrcNode;
    public String endIfToken;
//    public ifStrcNode() {}

    public ifStrcNode(int lineNumber, int colNumber, ifCondNode ifCondNode, String thenToken, LinesNode linesNode,@Nullable List<elseIfStrcNode> elseIfStrcNodes, @Nullable elseStrcNode elseStrcNode ) {
        super(lineNumber, colNumber);
        this.ifCondNode = ifCondNode;
        this.thenToken = thenToken;
        this.lines = linesNode;
        this.elseIfStrcNodes = elseIfStrcNodes;
        this.elseStrcNode = elseStrcNode;
    }
}
