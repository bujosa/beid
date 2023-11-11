package com.bujosa.beid.common.functions;

public class Operations {

    public static String trimBrackets(String message) {
        return message.replaceAll("[\\[\\]]", "");
    }
}