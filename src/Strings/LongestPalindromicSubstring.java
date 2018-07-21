package Strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindrome("bbbbd"));
        System.out.println(longestPalindrome("cddb"));
        System.out.println(longestPalindrome("cddd"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome(null));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("aaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaaaaabaaaa"));

    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        int start;
        int end;
        int max = Integer.MIN_VALUE;
        String result = "";

        for (int left = 0; left < s.length() && s.length() - left > max; left++) {
            for (int right = s.length() - 1; right >= left; right--) {

                while (s.charAt(left) != s.charAt(right) && left < right) {
                    right--;
                }

                start = left;
                end = right;
                while (s.charAt(left) == s.charAt(right) && left < right) {
                    left++;
                    right--;
                }

                if (left >= right) {
                    int len = end - start + 1;
                    if (len > max) {
                        result = s.substring(start, end + 1);
                        max = len;
                    }
                }
            }
        }


        return result;
    }
}
