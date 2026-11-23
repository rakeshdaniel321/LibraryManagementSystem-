package com.rakesh.lms.validation;

public class Validator {
    private Validator() {}

    public static boolean isText(String v) {
        return v != null && !v.trim().isEmpty();
    }

    public static boolean isName(String v) {             
        return v != null && v.trim().matches("^[A-Za-z .]{2,50}$");
    }

    public static boolean isPositive(int v) {
        return v > 0;
    }

    public static boolean isMobile(String v) {            
        return v != null && v.trim().matches("^[6-9]\\d{9}$");
    }
}
