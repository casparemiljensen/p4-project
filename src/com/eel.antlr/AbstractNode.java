package com.eel.antlr;

import java.util.*;

public abstract class AbstractNode {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String toString() {
        return("" + getName());
    }

    public AbstractNode() {}

    public final void accept(ReflectiveVisitor v) { v.dispatch(this); }



}
