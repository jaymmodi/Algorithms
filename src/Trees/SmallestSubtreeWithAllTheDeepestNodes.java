package Trees;

public class SmallestSubtreeWithAllTheDeepestNodes {

    private static TreeNode output = null;

    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();

        System.out.println(subtreeWithAllDeepest(root));
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = getDepth(root);
        helper(root, maxDepth, 0);
        return output;
    }

    private static int helper(TreeNode root, int maxDepth, int depth) {
        if (root == null) {
            return depth;
        }

        int left = helper(root.left, maxDepth, depth + 1);
        int right = helper(root.right, maxDepth, depth + 1);

        if (left == maxDepth && right == maxDepth) {
            output = root;
        }

        return Math.max(left, right);
    }

    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
