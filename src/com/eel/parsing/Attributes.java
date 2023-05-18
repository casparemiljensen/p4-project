package com.eel.parsing;

import com.eel.AST.nodes.Type;

public class Attributes {
    private Enum<Type> type;
    private EelScope scope;
    private Enum<Type> dataType;

    public Attributes(Enum<Type> type, EelScope scope) {
        this.type = type;
        this.scope = scope;
    }
    public Attributes(Enum<Type> type, Enum<Type> dataType, EelScope scope ) {
        this.type = type;
        this.dataType = dataType;
        this.scope = scope;
    }

    public Enum<Type> getDataType() {
        return dataType;
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
