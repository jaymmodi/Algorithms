package Trees;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree();

        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
