package Trees;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 6, 0, 5};

        TreeNode x = constructMaximumBinaryTree(nums);
        System.out.println(x);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTreeHelper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);

        if (start <= maxIndex - 1) {
            root.left = constructMaximumBinaryTreeHelper(nums, start, maxIndex - 1);
        } else {
            root.left = null;
        }

        if (maxIndex + 1 <= end) {
            root.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, end);
        } else {
            root.right = null;
        }

        return root;
    }

    private static int findMaxIndex(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
