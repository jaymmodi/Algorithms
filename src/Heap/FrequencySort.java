package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aaabc"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer count = countMap.getOrDefault(c, 0);

            countMap.put(c, ++count);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            if (countMap.get(c1) > countMap.get(c2)) {
                return -1;
            } else if (countMap.get(c1) < countMap.get(c2)) {
                return 1;
            } else {
                return c1-c2;
            }
        });

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        StringBuilder output = new StringBuilder();
        while (!queue.isEmpty()) {
            output.append(queue.poll());
        }

        return output.toString();
    }
}
