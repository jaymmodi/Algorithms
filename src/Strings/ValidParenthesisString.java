package Strings;

public class ValidParenthesisString {

    public static void main(String[] args) {
//        System.out.println(checkValidString("(*)**((**))((**)"));
        System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
    }

    public static boolean checkValidString(String s) {
        if (null == s) {
            return false;
        }

        if (s.length() % 2 != 0) {
            s = s.replaceFirst("\\*", "");
        }

        int validBracketIndex = 0;
        int openBracketCount = 0;
        int closedBracketCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBracketCount++;
            } else if (s.charAt(i) == ')') {
                closedBracketCount++;
            }
        }

        while (s.length() >= 0) {
            System.out.println(s);
            if (s.isEmpty()) {
                return true;
            }
            if (s.contains("()")) {
                validBracketIndex = s.indexOf("()");
                openBracketCount--;
                closedBracketCount--;
            } else if (s.contains("**")) {
                validBracketIndex = s.indexOf("**");
            } else if (s.contains("(*")) {
                validBracketIndex = s.indexOf("(*");
                openBracketCount--;
            } else if (s.contains("*)")) {
                validBracketIndex = s.indexOf("*)");
                closedBracketCount--;
            } else {
                return false;
            }

            String firstPart = s.substring(0, validBracketIndex);
            String lastPart = "";
            if (validBracketIndex + 2 < s.length()) {
                lastPart = s.substring(validBracketIndex + 2, s.length());
            }

            s = firstPart + lastPart;
        }

        return true;
    }
}
