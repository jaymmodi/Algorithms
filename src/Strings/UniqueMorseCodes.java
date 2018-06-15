package Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodes {
    private static final String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();

        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : word.toCharArray()) {
                int index = c - 97;
                stringBuilder.append(codes[index]);
            }
            result.add(stringBuilder.toString());
        }


        return result.size();
    }


}
