package Trees;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree();

        System.out.println(minDepth(treeNode));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null) return 1 + minDepth(root.right);
            if (root.right == null) return 1 + minDepth(root.left);

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
