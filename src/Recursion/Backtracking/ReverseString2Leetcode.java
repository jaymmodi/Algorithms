package Recursion.Backtracking;

public class ReverseString2Leetcode {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {

        int startIndex = 0;
        StringBuilder ans = new StringBuilder();
        while (startIndex < s.length()) {
            int endIndex = startIndex + k * 2;

            if (endIndex > s.length()) {
                endIndex = s.length();
            }

            String substr = s.substring(startIndex, endIndex);
            ans.append(reverseSubStr(substr, k));
            startIndex = endIndex;
        }

        return ans.toString();
    }

    private static String reverseSubStr(String substr, int k) {
        if (substr.length() == 2 * k || (substr.length() > k && substr.length() < 2 * k)) {
            return reverseString(substr.substring(0, k)) + substr.substring(k, substr.length());
        } else {
            return reverseString(substr);
        }
    }

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            return "";
        }

        int mid = s.length() / 2;
        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < mid) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            ++left;
            --right;
        }

        return String.valueOf(chars);
    }

}
