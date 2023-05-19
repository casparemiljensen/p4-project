package com.eel.parsing;

import java.util.ArrayList;
import java.util.Stack;

public class SymbolTable {
    public EelScope currentScope;
    public final EelScope globalScope;
    final private Stack<EelScope> scopeStack = new Stack<>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();

    public SymbolTable() {
        globalScope = new EelScope("global");
        currentScope = globalScope;
    }

    //Adds a scope to the symbol table
    public Boolean addScope(String scopeName) {
        //Enters if the scope name has not already been used
        if (lookupScope(scopeName) == null) {
            EelScope scope = new EelScope(scopeName);
            scope.setParent(currentScope);
            currentScope.children.add(scope);
            scopeStack.push(currentScope);
            currentScope = scope;
            return true;
        } else return false;
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

    public EelScope getCurrentScope() {
        return currentScope;
    }

    //Enters a scope depending on the given scope name
    public void enterScope(String scopeName) {
        EelScope scope = this.findScope(scopeName, globalScope);

        if (scope != null) {
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    //Finds a scope based on the name
    private EelScope findScope(String scopeName, EelScope currentScope) {
        //Checks if the desired scope is the current scope
        if (currentScope.getScopeName().equals(scopeName)) {
            return currentScope;
        }

        EelScope scope = null;

        //Iterates through all nested scopes
        for (EelScope childScope : currentScope.children) {
            scope = this.findScope(scopeName, childScope);

            //Enters if the correct scope was found
            if (scope != null)
                break;
        }

        //Returns null if scope was not found
        return scope;
    }

    //Returns the scope or null if the scope was not found
    public EelScope lookupScope(String scopeName) {
        return this.findScope(scopeName, globalScope);
    }

    public Attributes lookupSymbol(String symbol) {
        EelScope scope = currentScope;
        boolean isNested = false;

        do {
            // Enters if the symbol is a parameter


            // Missing boolean check here??

            if (!scope.getParams().isEmpty() && scope.getParams().containsKey(symbol)) {
                return scope.getParams().get(symbol);
            }

            // Enters if the symbol is a regular symbol and it is found in the scope being searched through
            if (!isNested && !scope.getSymbols().isEmpty() && scope.getSymbols().containsKey(symbol)) {
                return scope.getSymbols().get(symbol);
            }

            // Goes to the outer scope
            scope = scope.getParent();

            // Sets isNested to true if entering a nested scope
            if (scope != null && scope.getParent() != null) {
                isNested = true;
            } else {
                isNested = false;
            }

        } while (scope != null);

        // Returns null if the symbol was not found in an accessible scope
        return null;
    }

    public void insertSymbol(String symbol, Attributes attributes) {
        currentScope.getSymbols().put(symbol, attributes);
    }

    public void insertParam(String id, Attributes attributes) {
        currentScope.getParams().put(id, attributes);
    }


}