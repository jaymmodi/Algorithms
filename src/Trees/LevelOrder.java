package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree();
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //level indicator

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (null == node) {
                List<Integer> copyList = new ArrayList<>(list);
                result.add(copyList);
                list.clear();

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                list.add(node.val);

                if (null != node.left) {
                    queue.add(node.left);
                }

                if (null != node.right) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
