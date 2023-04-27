package com.eel.antlr;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;
import java.util.List;

public class AST<T> {
    Token token;
    List<AST> children;

    public AST(){};
    public AST(Token token) { this.token = token; }

    public AST(int tokenType) { this.token = new CommonToken(tokenType); }

    /** external visitors execute the same action for all nodes
     * with same node type while walking
     */
    public int getNodeType() { return token.getType(); }

    public void addChild(AST t) {
        if (children == null) children = new ArrayList<>();
        children.add(t);
    }

    public List<AST> getChildren() { return children; }

    /** to represent flat lists. A list is a subtree w/o a root, which we simulate
     * with a nil root node. A nil node is a node with token == null.
     */
    public boolean isNil() { return token == null; }

    /** Compute string for single node */
    public String toString() {

        if(token != null) {
            String typeName = eelParser.VOCABULARY.getSymbolicName(getNodeType());
            typeName = typeName == null ? token.getText() : typeName;
            return token != null ? "<" +typeName +", '" + token.getText() +"'>": "nil";
        }
        return null;
    }

    /** Compute string for a whole tree */
    public String toStringTree() {
        if (children == null || children.size() == 0) return this.toString();

        StringBuffer buf = new StringBuffer();
        if (!isNil()) {
            buf.append('(');
            buf.append(this.toString());
            buf.append(' ');
        }
        for (int i = 0; i < children.size(); i++) {
            AST t = (AST) children.get(i); // normalized (unnamed) children
            if (i>0) buf.append(' ');
            buf.append(t.toStringTree());
        }
        if (!isNil()) buf.append(')');
        return buf.toString();
    }
}
