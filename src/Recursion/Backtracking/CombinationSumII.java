package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {3, 1, 3, 5, 1, 1};

        System.out.println(combinationSum2(candidates, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        List<Integer> currentList = new ArrayList<>();
        combinationSumHelper(candidates, target, result, currentList, 0);

        return result;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i <= candidates.length - 1; i++) {
                if (i > start && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                int currentNumber = candidates[i];

                if (target - currentNumber >= 0) {
                    currentList.add(currentNumber);
                    combinationSumHelper(candidates, target - currentNumber, result, currentList, i + 1);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }
}
