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
        String newString = A;
        while (newString.length() < B.length()) {
            newString = newString + A;
            repeat++;
        }

        if (newString.contains(B)) {
            return repeat;
        } else {
            newString = newString + A;
            repeat++;
            return newString.contains(B) ? repeat : -1;
        }
    }
}
