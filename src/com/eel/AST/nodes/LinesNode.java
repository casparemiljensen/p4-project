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

    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LinesNode() {};
}
