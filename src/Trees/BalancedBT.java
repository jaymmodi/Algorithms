package Trees;

public class BalancedBT {
    public static void main(String[] args) {
        System.out.println(isBalanced(SampleTree.getBinaryTree()));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == -1 || right == -1) {
            return false;
        }

        return Math.abs(left - right) <= 1;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            if (left == -1 || right == -1) {
                return -1;
            }
            if (Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
    }
}
