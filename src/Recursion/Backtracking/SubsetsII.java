package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        List<List<Integer>> sets = subsets(nums);

        for (List<Integer> set : sets) {
            System.out.println("set --- ");

            for (Integer integer : set) {
                System.out.println(integer);
            }
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        Set<String> subStrings = new HashSet<>();
        subsets(nums, 0, subset, subsets, subStrings);

        return subsets;
    }

    private static void subsets(int[] nums, int offset, List<Integer> subset, List<List<Integer>> subsets, Set<String> substrings) {
        if (offset == nums.length) {
            if (!substrings.contains(subset.toString())) {
                substrings.add(subset.toString());
                subsets.add(new ArrayList<>(subset));
            }
        } else {
            subset.add(nums[offset]);
            subsets(nums, offset + 1, subset, subsets, substrings);
            subset.remove(subset.size() - 1);
            subsets(nums, offset + 1, subset, subsets, substrings);
        }
    }
}

