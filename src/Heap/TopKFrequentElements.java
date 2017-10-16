package Heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        topKFrequent(nums, 2).forEach(System.out::println);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> set : countMap.entrySet()) {
            queue.offer(set);
        }

        while (result.size() < k) {
            result.add(queue.poll().getKey());
        }

        return result;
    }
}
