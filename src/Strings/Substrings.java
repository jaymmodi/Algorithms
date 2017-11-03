package Strings;

import java.util.HashMap;
import java.util.Map;

public class Substrings {

    public static void main(String[] args) {
        String str = "appleseed";

        Map<String, Boolean> dictionary = new HashMap<>();
        dictionary.put("apple", true);
        dictionary.put("seed", true);
        System.out.println(checkSubstrings(str, dictionary));
    }

    private static boolean checkSubstrings(String str, Map<String, Boolean> dictionary) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (!substring.equals(str) && dictionary.containsKey(substring)) {
                    return dictionary.get(substring);
                }
            }
        }
        return false;
    }
}
