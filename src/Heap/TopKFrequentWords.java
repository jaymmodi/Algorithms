package Heap;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        topKFrequent(words, 4).forEach(System.out::println);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || words == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        Comparator<Map.Entry<String, Integer>> entryComparator = (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> {
            if (Objects.equals(b.getValue(), a.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else if (b.getValue() > a.getValue()) {
                return 1;
            } else {
                return -1;
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(entryComparator);

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> set : countMap.entrySet()) {
            queue.offer(set);
        }

        while (result.size() < k) {
            result.add(queue.poll().getKey());
        }

        return result;
    }
}
