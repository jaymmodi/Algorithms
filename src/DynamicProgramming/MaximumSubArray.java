package DynamicProgramming;

public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = {-1, -2, -3};
        int nums2[] = {-1, -2, -3, 5};
        int nums3[] = {1, 2, 3, 5};
        int nums4[] = {20, 100, -110, 100};
        int nums5[] = {20, 100, -100, 200};

        System.out.println(maxSubArrayDynamic(nums));
        System.out.println(maxSubArrayBruteForce(nums));

        System.out.println(maxSubArrayDynamic(nums4));
        System.out.println(maxSubArrayBruteForce(nums4));

        System.out.println(maxSubArrayDynamic(nums5));
        System.out.println(maxSubArrayBruteForce(nums5));
    }

    private static int maxSubArrayDynamic(int[] nums) {
        int solution[] = new int[nums.length];

        solution[0] = nums[0];
        int max = solution[0];

        for (int i = 1; i < nums.length; i++) {
            solution[i] = Math.max(solution[i - 1] + nums[i], nums[i]);

            if (solution[i] > max) {
                max = solution[i];
            }
        }

        return max;
    }

    public static int maxSubArrayBruteForce(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int start = 0; start <= nums.length - 1; start++) {
            for (int end = nums.length - 1; end >= start; end--) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }

        return max;
    }
}
