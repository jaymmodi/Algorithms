package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{3, 0, -2, -1, 1, 2});

        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 2) {
            Arrays.sort(nums);
            int previousNumber = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int number = nums[i];
                if (previousNumber != number) {
                    List<List<Integer>> lists = twoSum(nums, i + 1, 0 - nums[i]);

                    if (lists.size() > 0) {
                        for (List<Integer> list : lists) {
                            list.add(number);

                            result.add(list);
                        }
                    }

                    previousNumber = number;
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, int startIndex, int sumRequired) {
        List<List<Integer>> result = new ArrayList<>();
        int endIndex = nums.length - 1;
        int preStart = Integer.MIN_VALUE;
        int preEnd = Integer.MIN_VALUE;

        while (startIndex < endIndex) {
            int currentSum = nums[startIndex] + nums[endIndex];

            if (currentSum == sumRequired) {
                if (preStart != nums[startIndex] && preEnd != nums[endIndex]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[startIndex]);
                    list.add(nums[endIndex]);

                    preStart = nums[startIndex];
                    preEnd = nums[endIndex];

                    result.add(list);
                }
                startIndex++;
                endIndex--;
            } else if (currentSum > sumRequired) {
                endIndex--;
            } else if (currentSum < sumRequired) {
                startIndex++;
            }
        }

        return result;
    }
}
