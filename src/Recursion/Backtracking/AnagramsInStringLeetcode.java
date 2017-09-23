package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnagramsInStringLeetcode {

    public static void main(String[] args) {
        List<Integer> startIndices = findAnagrams("cbaebabacd", "abc");

        startIndices.forEach(System.out::println);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        Set<String> permutations = findPermutations(p);

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String substring = s.substring(i, i + p.length());

            if (permutations.contains(substring)) {
                result.add(i);
            }

        }

        return result;
    }

    private static Set<String> findPermutations(String p) {
        char[] chars = p.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Set<String> result = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            visited[i] = true;
            permute(chars, visited, "" + chars[i], result);
            visited[i] = false;
        }

        return result;
    }

    private static void permute(char[] chars, boolean[] visited, String currentString, Set<String> result) {
        if (currentString.length() == chars.length) {
            result.add(currentString);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    currentString = currentString + String.valueOf(chars[i]);

                    permute(chars, visited, currentString, result);

                    visited[i] = false;
                    currentString = currentString.substring(0, currentString.length() - 1);
                }
            }
        }
    }
}

