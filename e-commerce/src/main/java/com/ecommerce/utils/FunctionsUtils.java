package com.ecommerce.utils;

public class FunctionsUtils {
    public static String Slice(String text, int n) {
        if (text == null || text.isEmpty() || n <= 0) {
            return "";
        }
        return text.length() <= n ? text : text.substring(0, n) + "...";
    }
}
