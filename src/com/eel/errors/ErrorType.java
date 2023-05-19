package com.eel.errors;

public enum ErrorType {
    TYPE_ERROR("420"),
    ILLEGAL_TYPE_CONVERSION("I1"),
    DUPLICATE_PROCEDURE("E3"),
    DUPLICATE_RETURN("E5"),
    VARIABLE_NOT_INITIALED("E4"),
    CANNOT_EVALUATE_COMPARISON("E6"),
    CANNOT_EVALUATE_EQUALITY("E7"),
    DUPLICATE_VARIABLE("E2"),
    DUPLICATE_SCOPE("E3"),
    GENERAL_WARNING("W1"),
    UNDECLARED_FUNCTION_WARNING("W2");

    public final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
