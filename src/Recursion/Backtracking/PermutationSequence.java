package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Get kth permutation of [1,2,3...n] sequence
 */

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(9, 78494));
    }

    public static String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                sb.append(i);
            }

            return sb.toString();
        }

        List<String> allPermutations = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        boolean visited[] = new boolean[n];
        helper(nums, allPermutations, sb, visited, k);
        System.out.println(allPermutations);

        return allPermutations.get(k - 1);
    }

    private static void helper(int[] nums, List<String> allPermutations, StringBuilder sb, boolean[] visited, int k) {

        if (sb.length() == nums.length) {
            allPermutations.add(sb.toString());
        } else {
            if (allPermutations.size() <= k) {
                for (int i = 0; i < nums.length; i++) {
                    if (!visited[i]) {
                        sb.append(nums[i]);
                        visited[i] = true;

                        helper(nums, allPermutations, sb, visited, k);

                        visited[i] = false;
                        sb.setLength(sb.length() - 1);
                    }
                }
            }
        }

    }
}
