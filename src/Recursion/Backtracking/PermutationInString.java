package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
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

        boolean visited[] = new boolean[s1.length()];
        List<String> inclusiveSubstrings = new ArrayList<>();
        checkInclusionHelper(chars, visited, "", inclusiveSubstrings, s2);

        return inclusiveSubstrings.size() > 0;
    }

    private static void checkInclusionHelper(char[] chars, boolean[] visited, String newString, List<String> inclusiveSubtrings, String s2) {
        if (newString.length() == chars.length && s2.contains(newString)) {
            inclusiveSubtrings.add(newString);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (!visited[i]) {
                    char c = chars[i];

                    visited[i] = true;
                    newString += c;

                    checkInclusionHelper(chars, visited, newString, inclusiveSubtrings, s2);

                    visited[i] = false;
                    newString = newString.substring(0, newString.length() - 1);
                }
            }
        }
    }
}
