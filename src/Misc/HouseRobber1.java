package Misc;

public class HouseRobber1 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 2};
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
        int max = 0;
        int previousMax = 0;
        if (nums.length >= 2) {
            max = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            previousMax = nums[nums.length - 1];
        }

        for (int i = nums.length - 3; i >= 0; i--) {
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
