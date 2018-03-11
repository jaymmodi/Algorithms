package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuteNumbers {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});

        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            visited[i] = true;
            tempList.add(nums[i]);

            permuteHelper(nums, visited, tempList, result);

            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }

        return result;
    }

    private static void permuteHelper(int[] nums, boolean[] visited, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {

            for (int i = 0; i < nums.length; i++) {
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
