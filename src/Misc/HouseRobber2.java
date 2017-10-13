package Misc;

public class HouseRobber2 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 7, 5, 3, 1};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
    }

    public static int rob(int[] nums, int start, int end) {
        int max = 0;
        int previousMax = 0;
        if (nums.length > 2) {
            max = Math.max(nums[end], nums[end - 1]);
            previousMax = nums[end];
        }

        for (int i = end - 2; i >= start; i--) {
            if (nums[i] + previousMax > max) {
                int temp = previousMax;
                previousMax = max;
                max = nums[i] + temp;
            } else {
                previousMax = max;
            }

        }

        return max;
    }
}
