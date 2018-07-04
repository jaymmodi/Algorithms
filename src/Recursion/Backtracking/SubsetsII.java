package Recursion.Backtracking;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};

        List<List<Integer>> sets = subsets(nums);
        System.out.println(sets.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        Set<String> subStrings = new HashSet<>();
        Arrays.sort(nums);
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

