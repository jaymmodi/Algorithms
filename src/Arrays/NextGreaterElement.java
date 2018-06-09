package Arrays;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    int index = j + 1;
                    while (index < nums2.length && nums2[index] < nums1[i]) {
                        index++;
                    }

                    if (index > nums2.length - 1) {
                        result[i] = -1;
                    } else {
                        result[i] = nums2[index];
                    }
                }
            }

        }
        return result;
    }
}