package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuteNumbersII {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4});

        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        List<Integer> tempList = new ArrayList<>();
        permuteHelper(nums, tempList, result, visited);

        return result;
    }

    private static void permuteHelper(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    tempList.add(nums[i]);
                    visited[i] = true;

                    permuteHelper(nums, tempList, result, visited);

                    tempList.remove(tempList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

}
