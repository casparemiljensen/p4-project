package com.eel;

import java.util.*;

public class EelScope {
    private String scopeName;
    private EelScope parent;
    //The symbols in the scope
    private HashMap<String, Attributes> symbols = new HashMap<>();
    private Map<String, Attributes> params = new LinkedHashMap<>();

    //Nested scopes within the current scope
    List<EelScope> children = new ArrayList<>();

    public EelScope(String scopeName){
        this.scopeName = scopeName;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String name) {
        scopeName = name;
    }

    public EelScope getParent() {
        return parent;
    }

    public void setParent(EelScope parent) {
        this.parent = parent;
    }

    public HashMap<String, Attributes> getSymbols() {
        return symbols;
    }

    public void setSymbols(String id, Attributes attribute) {
        symbols.put(id, attribute);
    }

    public Map<String, Attributes> getParams() {
        return params;
    }

    public void addParams(String id, Attributes attribute) {
        params.put(id, attribute);
    }
}
