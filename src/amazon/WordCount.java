package amazon;

import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        wordMap("fast fastest faster fast", Arrays.asList("fa")).forEach(System.out::println);
    }

    public static List<String> wordMap(String litreatureText, List<String> wordsToExclude) {
        Map<String, Integer> wordCount = new HashMap<>();

        litreatureText = removePunctuation(litreatureText);
        String[] split = litreatureText.split(" ");

        List<String> excludedWords = new ArrayList<>();
        for (String wordToExclude : wordsToExclude) {
            excludedWords.add(wordToExclude.toLowerCase());
        }

        int max = Integer.MIN_VALUE;
        for (String word : split) {
            max = insertInMap(excludedWords, wordCount, max, word);
        }

        return getMostFrequentWords(wordCount, max);
    }

    private static String removePunctuation(String litreatureText) {
        return litreatureText.replaceAll("\\p{Punct}", " ").toLowerCase();
    }

    private static List<String> getMostFrequentWords(Map<String, Integer> wordCount, int max) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> stringIntegerEntry : wordCount.entrySet()) {
            if (stringIntegerEntry.getValue() == max) {
                result.add(stringIntegerEntry.getKey());
            }
        }
        return result;
    }

    private static int insertInMap(List<String> wordsToExclude, Map<String, Integer> wordCount, int max, String word) {
        if (!wordsToExclude.contains(word)) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                int newCount = ++count;

                if (newCount >= max) {
                    max = newCount;
                }
                wordCount.put(word, newCount);
            } else {
                wordCount.put(word, 1);
            }
        }
        return max;
    }
}
