package Trees;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();

        System.out.println(pathSum(root, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSumStart(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumStart(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        return (node.val == sum ? 1 : 0) + pathSumStart(node.left, sum - node.val) + pathSumStart(node.right, sum - node.val);
    }
}
