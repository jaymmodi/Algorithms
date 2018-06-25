package Strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (char key : countMap.keySet()) {
            count += countMap.get(key) % 2;
        }
        return count <= 1;
    }
}

