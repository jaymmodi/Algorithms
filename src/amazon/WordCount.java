package amazon;

import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        wordMap("fast fastest faster", Arrays.asList("fa")).forEach(System.out::println);
        System.out.println("****");
        wordMap("fast fastest faster fast", Arrays.asList("fa")).forEach(System.out::println);
        System.out.println("****");
        wordMap("fast", Arrays.asList("fa")).forEach(System.out::println);
        System.out.println("****");
        wordMap("", Arrays.asList("fa")).forEach(System.out::println);
        System.out.println("****");
        wordMap(" ", Arrays.asList("fa")).forEach(System.out::println);
        System.out.println("****");
        wordMap("jack and jill went to the market to buy bread and cheese and cheese is jack favourite food", Arrays.asList("and", "he", "the", "to", "is")).forEach(System.out::println);
        System.out.println("****");
    }

    public static List<String> wordMap(String literatureText, List<String> wordsToExclude) {
        if (literatureText.trim().isEmpty()) {
            return new ArrayList<>();
        }

        if (literatureText.split(" ").length == 1) {
            return Collections.singletonList(literatureText);
        }

        Map<String, Integer> wordCount = new HashMap<>();

        int max = 1;
        String[] split = literatureText.split(" ");
        for (String word : split) {
            max = insertInMap(wordsToExclude, wordCount, max, word);
        }

        return getMostFrequentWords(wordCount, max);
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
