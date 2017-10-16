package Heap;

import java.util.*;

public class TopKFrequentWords3 {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        topKFrequent(words, 1).forEach(System.out::println);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || words == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        Comparator<Map.Entry<String, Integer>> ascending = (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> {
            if (Objects.equals(b.getValue(), a.getValue())) {
                return b.getKey().compareTo(a.getKey()); // descending
            } else {
                return a.getValue() - b.getValue();
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(ascending);
        int min = Integer.MAX_VALUE;

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> set : countMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(set);
            } else {
                if (set.getValue() > min) {
                    minHeap.poll();
                    minHeap.offer(set);
                } else if (set.getValue() == min) {
                    if (set.getKey().compareTo(minHeap.peek().getKey()) < 0) {
                        minHeap.poll();
                        minHeap.offer(set);
                    }
                }
            }
            min = minHeap.peek().getValue();
        }

        while (minHeap.size() != 0) {
            result.add(0, minHeap.poll().getKey());
        }

        return result;
    }
}
