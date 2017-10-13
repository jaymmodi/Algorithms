package Trees;

public class HouseRobber3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.right = new TreeNode(3);

        right.right = new TreeNode(1);

        root.right = right;
        root.left = left;

        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val + sum, rob(root.right) + rob(root.left));
    }

}
