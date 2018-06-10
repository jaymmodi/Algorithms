package Arrays;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {3, 2, 3};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }

        Arrays.sort(nums);
        if (nums[nums.length / 2] == nums[0]) {
            return nums[0];
        } else if (nums[nums.length / 2] == nums[nums.length - 1]) {
            return nums[nums.length - 1];
        } else {
            return nums[nums.length / 2];
        }
    }
}
