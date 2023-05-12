package com.eel.errors;

public enum ErrorType {
    TYPE_ERROR("420"),
    IMPLICIT_TYPE_CONVERSION("I1"),
    DUPLICATE_VARIABLE("E2"),
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
