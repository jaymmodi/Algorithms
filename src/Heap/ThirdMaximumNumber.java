package Heap;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int nums[] = {3, 2, 1}; // 1
        int nums2[] = {1, 1, 2}; // 2
        int nums3[] = {2, 2, 3, 1}; // 1
        int nums4[] = {1000, 1000, 1000, 1000}; // 1000
        int nums5[] = {1, 1, 1}; //1
        int nums6[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}; //Integer.MAX_VALUE
        int nums7[] = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}; //Integer.MIN_VALUE
        int nums8[] = {Integer.MIN_VALUE, -1, 1, 2}; //-1
        int nums9[] = {Integer.MIN_VALUE, -1, 1}; //Integer.MIN_VALUE
        int nums10[] = {2, 2, 2, 1}; //2
        int nums11[] = {1, 1, 1, 2, 2, 2, 8}; //1
        int nums12[] = {1, 1, 1, 2, 2, 2}; //2
        int nums13[] = {1, 2, Integer.MIN_VALUE}; //Integer.MIN_VALUE

        System.out.println(thirdMax(nums));
        System.out.println(thirdMax(nums2));
        System.out.println(thirdMax(nums3));
        System.out.println(thirdMax(nums4));
        System.out.println(thirdMax(nums5));
        System.out.println(thirdMax(nums6));
        System.out.println(thirdMax(nums7));
        System.out.println(thirdMax(nums8));
        System.out.println(thirdMax(nums9));
        System.out.println(thirdMax(nums10));
        System.out.println(thirdMax(nums11));
        System.out.println(thirdMax(nums12));
        System.out.println(thirdMax(nums13));
    }

    public static int thirdMax(int[] nums) {
        int max;
        int secondMax;
        int thirdMax = Integer.MIN_VALUE;
        boolean assigned = false;

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] >= nums[1] ? nums[0] : nums[1];
        }

        if (nums[0] > nums[1]) {
            max = nums[0];
            secondMax = nums[1];
        } else if (nums[0] < nums[1]) {
            max = nums[1];
            secondMax = nums[0];
        } else {
            max = nums[0];
            secondMax = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                if (max != secondMax) {
                    thirdMax = secondMax;
                    assigned = true;
                }
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] < max) {
                thirdMax = secondMax;
                assigned = true;
                secondMax = nums[i];
            } else if (nums[i] >= thirdMax && nums[i] < secondMax) {
                if (max != secondMax) {
                    thirdMax = nums[i];
                    assigned = true;
                }
            }
        }

        return !assigned ? max : thirdMax;
    }
}
