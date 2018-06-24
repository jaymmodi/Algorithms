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
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r - 1) || isPalindromic(s, l + 1, r);
            l++;
            r--;
        }
        return true;
    }

    private static boolean isPalindromic(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

