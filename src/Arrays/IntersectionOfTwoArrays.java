package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> intersection = new HashSet<>();
        if (nums2.length <= nums1.length) {
            for (int num : nums2) {
                if (!intersection.contains(num)) {
                    boolean found = findInOtherArray(nums1, num);
                    if (found) {
                        intersection.add(num);
                    }
                }
            }
        } else {
            for (int num : nums1) {
                if (!intersection.contains(num)) {
                    boolean found = findInOtherArray(nums2, num);
                    if (found) {
                        intersection.add(num);
                    }
                }
            }
        }

        int result[] = new int[intersection.size()];

        int index = 0;
        for (int num : intersection) {
            result[index] = num;
            index++;
        }

        return result;
    }

    private static boolean findInOtherArray(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }

        return false;
    }
}
