package com.ecommerce.utils;
import org.mindrot.jbcrypt.BCrypt;


import java.util.regex.Pattern;

public class FunctionsUtils {

    public static String Slice(String text, int n) {
        if (text == null || text.isEmpty() || n <= 0) {
            return "";
        }
        return text.length() <= n ? text : text.substring(0, n) + "...";
    }



    public static boolean isValidPassword(String password) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

        if (password == null) {
            return false;
        }

        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }



    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
