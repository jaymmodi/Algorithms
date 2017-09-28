package Recursion.Backtracking;

public class ReverseString2 {

    public static void main(String[] args) {
        String str = "jay modi";

        System.out.println(reverseString(str));
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
