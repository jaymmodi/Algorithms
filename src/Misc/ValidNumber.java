package Misc;

import java.util.regex.Pattern;

public class ValidNumber {

    public static void main(String[] args) {
        System.out.println(isNumber("12-12"));
    }

    public static boolean isNumber(String s) {
        if (null == s || s.trim().isEmpty()) {
            return false;
        }

        String pattern = "^[+-]?((\\d*\\.\\d+)|(\\d+(\\.\\d*)?))([eE][+-]?\\d+)?$";

        return Pattern.compile(pattern).matcher(s.trim()).matches();
    }
}
