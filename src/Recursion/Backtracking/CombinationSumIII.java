package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k > 9) {
            return result;
        }

        int minKSum = minSum(k);
        int maxSum = maxSum(k);

        if (n < minKSum || n > maxSum) {
            return result;
        }

        List<Integer> currentList = new ArrayList<>();
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSumHelper(k, n, currentList, result, nums, 0);


        return result;
    }

    private static void combinationSumHelper(int k, int target, List<Integer> currentList, List<List<Integer>> result, int[] nums, int start) {
        if (currentList.size() == k && target == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < nums.length; i++) {
                int currentNumber = nums[i];

                if (target - currentNumber >= 0) {
                    currentList.add(currentNumber);
                    combinationSumHelper(k, target - currentNumber, currentList, result, nums, i + 1);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }

    private static int minSum(int k) {
        int sum = 0;

        for (int i = 1; i <= k; i++) {
            sum += i;
        }

        return sum;
    }

    private static int maxSum(int k) {
        int sum = 0;

        for (int i = 9; i > 9 - k; i--) {
            sum += i;
        }

        return sum;
    }
}
