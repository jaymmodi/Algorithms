package Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums1 = {11, 2, 3};
        int[] nums2 = {1, 2, 1};
        int[] nums3 = {1, 2, 1, 2};
        int[] nums4 = {25, 25, 10, 30, 5, 5, 1, 100};
        int[] nums5 = {-1, -1, -1};
        int[] nums6 = {-1, -1, -2, 0, 1};
        int[] nums7 = {-1, -1, -1, 0, 1, 1};
        int[] nums8 = {0, 1};
        int[] nums9 = {0};
        int[] nums10 = {1};

        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        System.out.println(pivotIndex(nums3));
        System.out.println(pivotIndex(nums4));
        System.out.println(pivotIndex(nums5));
        System.out.println(pivotIndex(nums6));
        System.out.println(pivotIndex(nums7));
        System.out.println(pivotIndex(nums8));
        System.out.println(pivotIndex(nums9));
        System.out.println(pivotIndex(nums10));

    }


    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int total = sum(nums);
        int leftSum = 0;
        int index = 0;
        int rightSum = total - leftSum - nums[index];

        while (index < nums.length - 1) {
            if (leftSum == rightSum) {
                return index;
            }

            leftSum = leftSum + nums[index];
            index++;
            rightSum = rightSum - nums[index];
        }

        if (index == nums.length - 1) {
            rightSum = 0;
            if (leftSum == rightSum) {
                return index;
            }
        }

        return -1;
    }

    private static int sum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
