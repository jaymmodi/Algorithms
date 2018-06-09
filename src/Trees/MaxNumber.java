package Trees;

public class MaxNumber {

    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();

        System.out.println(maxNodeValue(root));
    }

    private static int maxNodeValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rootValue = root.val;
        int leftValue = maxNodeValue(root.left);
        int rightValue = maxNodeValue(root.right);

        int max = Math.max(rootValue, leftValue);

        return Math.max(max, rightValue);
    }
}
