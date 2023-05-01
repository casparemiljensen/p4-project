package com.eel.antlr;

import java.util.*;

public abstract class AbstractNode {

    private List<AbstractNode> children;
    private List<AbstractNode> siblings;


    public AbstractNode() {
        children = new ArrayList<>();
        siblings = new ArrayList<>();
    }

    public final void accept(ReflectiveVisitor v) { v.dispatch(this); }


    public boolean addChild(AbstractNode node) {
        if(children.add(node)) {
            return true;
        }
        return false;
    }

    public boolean addSibling(AbstractNode node) {
        if(siblings.add(node)) {
            return true;
        }
        return false;
    }

    public List<AbstractNode> getChildren() {
        if(children != null) {
            return children;
        }
        return null;
    }

    public List<AbstractNode> getSiblings() {
        if(siblings != null) {
            return siblings;
        }
        return null;
    }

}
