package com.eel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private EELScope currentScope;
    final private EELScope globalScope;
    final private Stack<EELScope> scopeStack = new Stack<>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();
    public ArrayList<String> calledFunctions = new ArrayList<>();
    public HashMap<String, PinAttributes> pinList = new HashMap<>();

    public SymbolTable() {
        globalScope = new EELScope("global");
        currentScope = globalScope;
    }

    //Adds a scope to the symbol table
    public void addScope(String scopeName) {
        //Enters if the scope name has not already been used
        if (lookupScope(scopeName) == null) {
            CStarScope scope = new CStarScope(scopeName);
            scope.setParent(currentScope);
            currentScope.children.add(scope);
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    public void leaveScope() {
        this.leaveScope(null);
    }

    public void leaveScope(String scopeName) {
        //Enters if non-global scope
        if (currentScope.getParent() != null) {
            if (scopeName != null) {
                currentScope.setScopeName(scopeName);
            }

            //Removes the scope from the stack and set current scope to the outer scope
            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
        }
    }

    public CStarScope getCurrentScope() {
        return currentScope;
    }

    //Enters a scope depending on the given scope name
    public void enterScope(String scopeName) {
        CStarScope scope = this.findScope(scopeName, globalScope);

        if (scope != null) {
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    //Finds a scope based on the name
    private CStarScope findScope(String scopeName, CStarScope current_scope) {
        //Checks if the desired scope is the current scope
        if (current_scope.getScopeName().equals(scopeName)) {
            return current_scope;
        }

        CStarScope scope = null;

        //Iterates through all nested scopes
        for (CStarScope childScope : current_scope.children) {
            scope = this.findScope(scopeName, childScope);

            //Enters if the correct scope was found
            if (scope != null)
                break;
        }

        //Returns null if scope was not found
        return scope;
    }

    //Returns the scope or null if the scope was not found
    public CStarScope lookupScope(String scopeName){
        return this.findScope(scopeName, globalScope);
    }

    //Returns the attributes for the symbol that is being looked up
    public Attributes lookupSymbol(String symbol) {
        CStarScope scope = currentScope;

        do {
            //Enters if the symbol is a parameter
            if (!scope.getParams().isEmpty() && scope.getParams().containsKey(symbol)) {
                return scope.getParams().get(symbol);
            }
            //Enters if the symbol is a regular symbol and it is found in the scope being searched through
            if (!scope.getSymbols().isEmpty() && scope.getSymbols().containsKey(symbol)) {
                return scope.getSymbols().get(symbol);
            }
            //Goes to the outer scope
        } while((scope = scope.getParent()) != null);

        //Returns null if the symbol was not found in an accessible scope
        return null;
    }

    public void insertSymbol(String symbol, Attributes attributes) {
        currentScope.getSymbols().put(symbol, attributes);
    }

    public void insertParam(String id, Attributes attributes){
        currentScope.getParams().put(id, attributes);
    }

    //Checks if the Arduino functions are declared
    public boolean isSetupAndLoopDefined() {
        return (declaredFunctions.contains("setup") && declaredFunctions.contains("loop"));
    }
}