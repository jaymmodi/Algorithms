package Heap;

import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aaabc"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {

        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            if (count[c1] > count[c2]) {
                return -1;
            } else if (count[c1] < count[c2]) {
                return 1;
            } else {
                return c1 - c2;
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
