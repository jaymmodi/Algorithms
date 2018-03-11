package Recursion.Backtracking;

import java.util.Arrays;

public class PermutationInStringBestCase {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        if (s2.contains(s1)) {
            return true;
        }

        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            if (s2.indexOf(aChar) < 0) {
                return false;
            }
        }

        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);

        String sortedS1 = String.valueOf(chars1);
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String substring = s2.substring(i, i + s1.length());

            if (s1.equals(substring)) {
                return true;
            }

            char[] substrChars = substring.toCharArray();
            Arrays.sort(substrChars);
            String sortedSubstr = String.valueOf(substrChars);

            if (sortedS1.equals(sortedSubstr)) {
                return true;
            }
        }

        return false;
    }
}
