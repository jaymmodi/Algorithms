package Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int num[] = {1, 3, 5, 6};

        System.out.println(searchInsert(num, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        return binarySearch(nums, start, end, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;

        if (start == end) {
            if (target > nums[end]) {
                return end + 1;
            }
            if (target < start && start == 0) {
                return 0;
            } else {
                return start;
            }
        } else {
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch(nums, start, mid, target);
            } else {
                return binarySearch(nums, mid + 1, end, target);
            }
        }
    }
}
