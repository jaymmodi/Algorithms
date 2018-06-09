package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNumber {

    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();
        System.out.println(maxNodeValue(root));

        System.out.println(maxNodeValueNonRecursive(root));
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

    private static int maxNodeValueNonRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val > max) {
                max = node.val;
            }

            if (null != node.left) {
                queue.add(node.left);
            }

            if (null != node.right) {
                queue.add(node.right);
            }
        }
        return max;
    }
}
