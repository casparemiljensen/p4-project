package com.eel;

import com.eel.AST.nodes.Type;

public class Attributes {
    private String kind;
    private Enum<Type> variableType;
    private String scope;
    private int arrayLength;

    public Attributes(String kind, Enum<Type> variableType) {
        this.kind = kind;
        this.variableType = variableType;
    }

    public Attributes(String kind, Enum<Type> variableType, int arrayLength) {
        this.kind = kind;
        this.variableType = variableType;
        this.arrayLength = arrayLength;
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

    public int getArrayLength() { return arrayLength; }
}
