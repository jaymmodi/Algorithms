package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SetMismatch {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4};

        int[] errorNums = findErrorNums(array);

        for (int errorNum : errorNums) {
            System.out.println(errorNum);
        }
    }

    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        int numsSize = nums.length;
        int allRangeSum = IntStream.rangeClosed(1, numsSize).sum();
        int arraySum = Arrays.stream(nums).sum();

        int duplicate = findDuplicateNumber(nums);
        int missingNumber = allRangeSum - (arraySum - duplicate);

        result[0] = duplicate;
        result[1] = missingNumber;

        return result;
    }

    private static int findDuplicateNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
                break;
            }

            set.add(num);
        }

        return duplicate;
    }
}
