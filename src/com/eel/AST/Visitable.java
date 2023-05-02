package com.eel.AST;

import com.eel.AST.nodes.AbstractNode;

public interface Visitable {
    public void pre(int i,  AbstractNode a);
    public void post(int i, AbstractNode a);
}

