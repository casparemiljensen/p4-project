package com.eel.parsing;

import com.eel.AST.nodes.Type;

public class Attributes {
    private Enum<Type> type;
    private EelScope scope;
    private String value;

    public Attributes(Enum<Type> type) {
        this.type = type;
    }
    public Attributes(Enum<Type> type, String value, EelScope scope ) {
        this.type = type;
        this.value = value;
        this.scope = scope;
    }

    public String getValue() {
        return value;
    }

    public Enum<Type> getType() {
        return type;
    }

    public EelScope getScope() {
        return scope;
    }

    public void setScope(EelScope scope) {
        this.scope = scope;
    }


}
