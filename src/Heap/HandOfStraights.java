package Heap;

import java.util.PriorityQueue;

public class HandOfStraights {

    public static void main(String[] args) {
        int hand[] = {1, 2, 3, 6, 3, 2, 4, 7, 8};

        System.out.println(isNStraightHand(hand, 3));
    }

    public static boolean isNStraightHand(int[] hand, int w) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.add(i);
        }

        while (minHeap.size() != 0) {
            int start = minHeap.poll();
            for (int i = 1; i < w; i++) {
                if (minHeap.remove(start + i)) {

                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
