package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 6, 5, 4, 8};
        int nums1[] = {3, 2, 1, 5, 6, 4};
        int nums2[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int nums3[] = {1};

        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKthLargest(nums1, 2));
        System.out.println(findKthLargest(nums2, 4));
        System.out.println(findKthLargest(nums3, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Comparator.reverseOrder());

        for (int num : nums) {
            queue.add(num);
        }

        int result = -1;
        for (int i = 1; i <= k; i++) {
            if (!queue.isEmpty()) {
                result = queue.poll();
            }
        }

        return result;
    }
}
