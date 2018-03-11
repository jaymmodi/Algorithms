package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteDuplicateNumbers {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 1, 2, 2});

        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        List<Integer> tempList = new ArrayList<>();
        permuteHelper(nums, visited, tempList, result);

        return result;
    }

    private static void permuteHelper(int[] nums, boolean[] visited, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    tempList.add(nums[i]);

                    permuteHelper(nums, visited, tempList, result);

                    visited[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }

        }
    }
}
