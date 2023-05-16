package com.eel.helpers;

public class HashCodeGenerator {

    public static String generateHashNameFromObject(String prefix, Object input) {
        return prefix + "-" + String.valueOf(input.hashCode());
    }
}