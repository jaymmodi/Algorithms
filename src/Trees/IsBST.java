package Trees;

public class IsBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);

        left.left = (new TreeNode(2));
        left.right = (new TreeNode(4));

        right.right = (new TreeNode(7));

        root.right = (right);
        root.left = (left);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (null == root) return true;

        return root.val > minValue && root.val < maxValue
                && isValidBST(root.left, minValue, root.val)
                && isValidBST(root.right, root.val, maxValue);
    }
}
