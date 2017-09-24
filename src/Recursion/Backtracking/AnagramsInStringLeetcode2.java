package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsInStringLeetcode2 {

    public static void main(String[] args) {
        List<Integer> startIndices = findAnagrams("cbaebabacd", "abc");

        startIndices.forEach(System.out::println);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return result;
        }

        HashMap<Character, Integer> characters = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            if (characters.containsKey(c)) {
                Integer value = characters.get(c);
                characters.put(c, ++value);
            } else {
                characters.put(c, 1);
            }
        }


        int right = 0, left = 0;
        int count = p.length();

        while (right < s.length()) {
            if (characters.containsKey(s.charAt(right))) {
                int charCount = characters.get(s.charAt(right));
                if (charCount >= 1) {
                    --count;
                }

                --charCount;
                characters.put(s.charAt(right), charCount);

                ++right;
            } else {
                ++right;
            }


            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                if (characters.containsKey(s.charAt(left))) {

                    int charCount = characters.get(s.charAt(left));
                    if (charCount >= 0) {
                        ++count;
                    }
                    ++charCount;
                    characters.put(s.charAt(left), charCount);

                    ++left;
                } else {
                    ++left;
                }
            }

        }

        return result;
    }
}

