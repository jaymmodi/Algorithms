package Trees;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree();

        System.out.println(sumOfLeftLeaves(treeNode));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum = sum + root.left.val;
            }
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
