package com.eel.parsing;

import java.util.Map;

public class SymbolTablePrinter {
    public void printSymbolTable(SymbolTable symbolTable) {
        printScope(symbolTable.globalScope);
    }

    private void printScope(EelScope scope) {
        System.out.println();
        System.out.println("[ --- Scope: " + scope.getScopeName()+" --- ]");
        System.out.println();
        System.out.println("Symbols:");
        for (Map.Entry<String, Attributes> entry : scope.getSymbols().entrySet()) {
            String symbol = entry.getKey();
            Attributes attributes = entry.getValue();
            System.out.println("---   Symbol   ---");
            System.out.println("  Name: " + symbol);
            System.out.println("  Attributes:");
            System.out.println("  Type: " + attributes.getType());
            if(attributes.getScope() != null) {
                System.out.println("  Scope: " + attributes.getScope().getScopeName());
            }
            System.out.println("  Value: " + attributes.getValue());
            System.out.println();
        }

        for (EelScope childScope : scope.children) {
            printScope(childScope);
        }
    }

}
