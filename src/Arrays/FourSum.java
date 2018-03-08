package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-7, -5, 0, 7, 1, 1, -10, -2, 7, 7, -2, -6, 0, -10, -5, 7, -8, 5});

        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 2) {
            Arrays.sort(nums);

            int previousFirstNumber = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int firstNumber = nums[i];
                int previousSecondNumber = Integer.MIN_VALUE;
                if (previousFirstNumber != firstNumber) {
                    for (int j = i + 1; j < nums.length; j++) {
                        int secondNumber = nums[j];
                        if (previousSecondNumber != secondNumber) {
                            List<List<Integer>> lists = twoSum(nums, j + 1, 28 - firstNumber - secondNumber);

                            if (lists.size() > 0) {
                                for (List<Integer> list : lists) {
                                    list.add(secondNumber);
                                    list.add(firstNumber);

                                    result.add(list);
                                }
                            }

                            previousSecondNumber = secondNumber;
                        }
                    }
                }
                previousFirstNumber = firstNumber;
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
