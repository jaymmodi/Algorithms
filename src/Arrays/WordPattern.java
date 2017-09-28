package Arrays;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abc", "b c a"));
    }

    public static boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty() && str.isEmpty()) {
            return true;
        }

        if (pattern.isEmpty() || str.isEmpty()) {
            return false;
        }

        String[] splits = str.split(" ");
        if (splits.length != pattern.length()) {
            return false;
        }

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < splits.length; i++) {
            String character = pattern.substring(i, i + 1);
            if (!map.containsKey(splits[i] + "w") && !map.containsKey(character)) { // both not present
                map.put(splits[i] + "w", character);
                map.put(character, splits[i] + "w");
            } else if (map.containsKey(splits[i] + "w") && map.containsKey(character)) { // both present
                String charInMap = map.get(splits[i] + "w");
                String wordInMap = map.get(character);

                if (!character.equals(charInMap) || !wordInMap.equals(splits[i] + "w")) {
                    return false;
                }
            } else { // either of them not present
                return false;
            }
        }


        return true;
    }
}
