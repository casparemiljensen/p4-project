package com.eel.parsing;

import com.eel.AST.nodes.Type;

public class Attributes {
    private String kind;
    private Enum<Type> variableType;
    private String scope;

    public Attributes(String kind, Enum<Type> variableType) {
        this.kind = kind;
        this.variableType = variableType;
    }

    public String getKind() {
        return kind;
    }

    public Enum<Type> getVariableType() {
        return variableType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


}
