package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        int[] ints = twoSum(nums, 25);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }

        return result;
    }
}
