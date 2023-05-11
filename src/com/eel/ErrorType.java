package com.eel;

public enum ErrorType {
    TYPE_ERROR("E1"),
    DUPLICATE_VARS("E2"),
    GENERAL_WARNING("W1"),
    UNDECLARED_FUNCTION_WARNING("W2");

    private final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
