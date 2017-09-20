package Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};

        moveZeros(nums);
    }

    private static void moveZeros(int[] nums) {
        int lastNumberIndex = -1;
        int firstZeroIndex = -1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && firstZeroIndex == -1) {
                firstZeroIndex = i;
            } else if (nums[i] != 0) {
                lastNumberIndex = i;
            }

            if (firstZeroIndex >= 0 && firstZeroIndex < lastNumberIndex) {
                int temp1 = nums[firstZeroIndex];
                nums[firstZeroIndex] = nums[lastNumberIndex];
                nums[lastNumberIndex] = temp1;

                lastNumberIndex = firstZeroIndex;
                firstZeroIndex = lastNumberIndex + 1;
            }
            i++;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
