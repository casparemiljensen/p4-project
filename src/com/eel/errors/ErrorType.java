package com.eel.errors;

public enum ErrorType {
    TYPE_ERROR("420"),
    ILLEGAL_TYPE_CONVERSION("I1"),
    DUPLICATE_PROCEDURE("E3"),
    DUPLICATE_VARIABLE("E2"),
    DUPLICATE_SCOPE("E3"),
    PARAMETERS_COUNT_MISMATCH("E4"),
    UNDECLARED_VARIABLE("E5"),
    MAIN_PROCEDURE_MISSING("E6"),
    GENERAL_WARNING("W1"),
    UNDECLARED_FUNCTION_WARNING("W2"),
    UNINITIALIZED_VARIABLE("W3");

    public final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
