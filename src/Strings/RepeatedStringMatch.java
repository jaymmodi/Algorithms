package Strings;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("ba", "ab"));
    }

    public static int repeatedStringMatch(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        if (A.isEmpty() || B.isEmpty()) {
            return -1;
        }

        int repeat = 1;
        StringBuilder newString = new StringBuilder(A);
        while (newString.length() < B.length()) {
            newString.append(A);
            repeat++;
        }

        if (newString.toString().contains(B)) {
            return repeat;
        } else {
            newString.append(A);
            repeat++;
            return newString.toString().contains(B) ? repeat : -1;
        }
    }
}
