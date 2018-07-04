package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuteNumbersII {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});

        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        permuteHelper(nums, tempList, result);

        return result;
    }

    private static void permuteHelper(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {

            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                permuteHelper(nums, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
