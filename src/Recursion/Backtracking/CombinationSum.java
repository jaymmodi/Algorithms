package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};

        System.out.println(combinationSum(candidates, 50));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates.length == 0) {
            return result;
        }

        List<Integer> currentList = new ArrayList<>();
        combinationSumHelper(candidates, target, result, currentList, 0);

        return result;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i <= candidates.length - 1; i++) {
                int currentNumber = candidates[i];

                if (target - currentNumber >= 0) {
                    currentList.add(currentNumber);
                    combinationSumHelper(candidates, target - currentNumber, result, currentList, i);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }
}
