package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree();

        System.out.println(zigzagLevelOrder(treeNode));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> levelList = new ArrayList<>();
        int level = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add(levelList);
                levelList = new ArrayList<>();
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            } else {
                if (level % 2 == 0 || levelList.size() == 0) {
                    levelList.add(current.val);
                } else {
                    levelList.add(0, current.val);
                }

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
