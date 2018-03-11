package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicates2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indicesMap = new HashMap<>();
        boolean result = false;

        for (int i = 0; i < nums.length; i++) {
            if (indicesMap.containsKey(nums[i])) {
                result = result || Math.abs(indicesMap.get(nums[i]) - i) <= k;
            }
            indicesMap.put(nums[i], i);

        }
        return result;
    }
}