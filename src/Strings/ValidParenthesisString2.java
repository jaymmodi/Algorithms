package Strings;

public class ValidParenthesisString2 {

    public static void main(String[] args) {
//        System.out.println(checkValidString("(*)**((**))((**)"));
        System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
    }

    public static boolean checkFromLeft(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int star = 0;
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                close++;
            } else {
                star++;
            }
            if (close > open + star) {
                return false;
            }
        }
        if (close == open || close - open <= star) {
            return true;
        }
        return false;
    }
    public static boolean checkFromRight(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int star = 0;
        int open = 0;
        int close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                open++;
            } else if (c == '(') {
                close++;
            } else {
                star++;
            }
            if (close > open + star) {
                return false;
            }
        }
        if (close == open || close - open <= star) {
            return true;
        }
        return false;
    }
    public static boolean checkValidString(String s) {
        return checkFromLeft(s) && checkFromRight(s);
    }
}
