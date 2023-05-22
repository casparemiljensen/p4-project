package com.eel.parsing;

import com.eel.AST.nodes.Type;

public class Attributes {
    private Enum<Type> type;
    private EelScope scope;
    private Enum<Type> dataType;

    public Attributes(Enum<Type> type, Enum<Type> dataType) {
        this.type = type;
        this.dataType = dataType;
    }


    public Enum<Type> getDataType() {
        return dataType;
    }

    public void setDataType(Enum<Type> dataType) {
        this.dataType = dataType;
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
