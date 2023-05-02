package com.eel.antlr;

public interface Visitable {
    public void pre(int i,  AbstractNode a);
    public void post(int i, AbstractNode a);
}

