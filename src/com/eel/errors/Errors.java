package com.eel.errors;

import java.util.ArrayList;
import java.util.List;

public class Errors {
    final public List<Item> errors = new ArrayList<>();
    private boolean hasErrors = false;
    public boolean containsErrors(){
        return hasErrors;
    }

    public void addEntry(ErrorType type, String message) {
        this.addEntry(type, message, 0, 0);
    }
    public void addEntry(ErrorType type, String message, int lineNumber, int column) {
        List<String> lines = new ArrayList<>();
        this.addEntry(type, message, lineNumber, column, lines);

        setHasErrors(type);
    }
    public void addEntry(ErrorType type, String message, int lineNumber, int column, List<String> lines){
        //Enters if the error has not been added to the error list yet
       // if (shouldBeAdded(type, message)) {
            this.errors.add(new Item(type, message, lineNumber, column, lines));

            setHasErrors(type);
       // }
    }

    private void setHasErrors(ErrorType type) {
        //Enters if an error was reported
        if (type != null) {
            hasErrors = true;
        }
    }

    private boolean shouldBeAdded(ErrorType type, String message) {
        //Enters if the error is of an undeclared function
        if (type == ErrorType.UNDECLARED_FUNCTION_WARNING) {
            //Extracts the function name from the error message
            String calledFunction = message.split("'", 3)[1];

            for (Item error : errors) {

                //Enters if the undeclared function has already been added to the error list of errors
                if (error.type == ErrorType.UNDECLARED_FUNCTION_WARNING &&
                        calledFunction.equals(error.message.split("'", 3)[1])) {
                    return false;
                }
            }
        }
        return true;
    }
}

