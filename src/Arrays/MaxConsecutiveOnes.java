package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 1, 1, 1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax++;
            }
            if (nums[i] == 0) {
                if (currentMax > max) {
                    max = currentMax;
                }

                currentMax = 0;
            }
        }

        return Math.max(max, currentMax);
    }
}
