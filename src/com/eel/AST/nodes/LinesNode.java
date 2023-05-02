package com.eel.AST.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LinesNode extends AbstractNode {
    @Nullable
    public List<DclNode> dclNodes;

    @Nullable
    public List<StmtNode> stmtNodes;
    @Nullable
    public List<CtrlStrcNode> ctrlStrcNodes;


    @Nullable
    public List<DclNode> getDclNodes() {
        return dclNodes;
    }

    public void setDclNodes(@Nullable List<DclNode> dclNodes) {
        this.dclNodes = dclNodes;
    }

    @Nullable
    public List<StmtNode> getStmtNodes() {
        return stmtNodes;
    }

    public void setStmtNodes(@Nullable List<StmtNode> stmtNodes) {
        this.stmtNodes = stmtNodes;
    }

    @Nullable
    public List<CtrlStrcNode> getCtrlStrcNodes() {
        return ctrlStrcNodes;
    }

    public void setCtrlStrcNodes(@Nullable List<CtrlStrcNode> ctrlStrcNodes) {
        this.ctrlStrcNodes = ctrlStrcNodes;
    }

    public LinesNode() {};
}
