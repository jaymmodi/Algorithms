package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        Arrays.asList(5,100,85).forEach(medianFinder::addNum);
        System.out.println(medianFinder.findMedian());
    }


    public void addNum(int num) {
        int max = maxHeap.peek() == null ? Integer.MAX_VALUE : maxHeap.peek();

        if (num <= max) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}
