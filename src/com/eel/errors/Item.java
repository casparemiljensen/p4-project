package com.eel.errors;

import java.util.List;

public class Item {
    public ErrorType type;
    public String message;
    public int lineNumber;
    public int column;
    public List<String> lines;

    public Item(ErrorType type, String message, int lineNumber, int column, List<String> lines) {
        this.type = type;
        this.message = message;
        this.lineNumber = lineNumber;
        this.column = column;
        this.lines = lines;
    }
}
