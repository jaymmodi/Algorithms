package Strings;

public class LongestPalindromeLength {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); //7
        System.out.println(longestPalindrome("bccccdd")); //7
        System.out.println(longestPalindrome("ccccdd")); //6
        System.out.println(longestPalindrome("aA")); //1
        System.out.println(longestPalindrome("ccc")); //3
        System.out.println(longestPalindrome("cccd")); //3
        System.out.println(longestPalindrome("ccd")); //3
        System.out.println(longestPalindrome("ccaaabbbbb")); //9
        System.out.println(longestPalindrome("ccaaabbbbbddd")); //11
        System.out.println(longestPalindrome("ababababa")); //9
    }

    public static int longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] chars = new int[256];
        for (char c : s.toCharArray()) {
            chars[c]++;
        }

        int length = 0;
        int longestOddNumber = Integer.MIN_VALUE;
        int otherOddNumberCount = 0;

        for (int i = 0; i < 256; i++) {
            int integer = chars[i];

            if (integer % 2 == 0) {
                length += integer;
            } else {
                if (integer == 1) {
                    longestOddNumber = integer;
                } else {
                    otherOddNumberCount++;
                    if (integer > longestOddNumber) {
                        longestOddNumber = integer;
                    }
                    length = length + integer - 1;
                }
            }
        }

        if (longestOddNumber == 1 || otherOddNumberCount > 0) {
            length++;
        }

        return length;
    }
}
