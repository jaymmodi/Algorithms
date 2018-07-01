package Trees;

import java.util.*;

public class AverageOfLevelsBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBST();

        System.out.println(averageOfLevels(treeNode));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if (null == root) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return Collections.singletonList((double) root.val);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add(sum / count);
                sum = 0;
                count = 0;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            } else {
                sum += current.val;
                count++;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }

        return result;
    }
}
