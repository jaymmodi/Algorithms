package Strings;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abaa"));
        System.out.println(validPalindrome("abb"));
        System.out.println(validPalindrome("amalayalam"));
        System.out.println(validPalindrome("maladyalam"));
        System.out.println(validPalindrome("malayalam"));
        System.out.println(validPalindrome("bcbbdb"));
        System.out.println(validPalindrome("bbcdbb"));
        System.out.println(validPalindrome("bbcbb"));
        System.out.println(validPalindrome("abbbb"));
        System.out.println(validPalindrome("cbbcc"));
    }

    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindromic(s, start, end - 1) || isPalindromic(s, start + 1, end);
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

