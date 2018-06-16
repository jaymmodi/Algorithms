package Strings;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J.length() == 0) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : J.toCharArray()) {
            countMap.put(c, 0);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            if (countMap.containsKey(c)) {
                count++;
            }
        }

        return count;
    }
}
