package Misc;

public class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return index + 1;
            }
            nums[index] = nums[index] * -1;
        }
        return -1;
    }
}
