package Recursion.Backtracking;

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String[] args) {
        int[] candidates = {4, 2, 1};

        System.out.println(combinationSum4(candidates, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memory =  new int[target+1];
        Arrays.fill(memory, -1);
        memory[0] = 1;

        return combinationSumHelper(nums, target, memory);
    }

    private static int combinationSumHelper(int[] candidates, int target, int[] memory) {
        if(memory[target] != -1){
            return memory[target];
        }

        int count = 0;
        for (int i = 0; i <= candidates.length - 1; i++) {
            int currentNumber = candidates[i];

            if (target - currentNumber >= 0) {
                count += combinationSumHelper(candidates, target - currentNumber, memory);
            }
        }

        memory[target] = count;
        return count;
    }
}
