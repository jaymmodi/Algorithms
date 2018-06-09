package Trees;

import java.util.*;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root1 = SampleTree.getSymmetricTree();
        TreeNode root2 = SampleTree.getBinaryTree();
        TreeNode root3 = SampleTree.getBinaryTree1();

        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetric(root2));
        System.out.println(isSymmetric(root3));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // level separator
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (null == node) {
                if (list.size() > 1 && list.size() % 2 != 0) {
                    return false;
                } else if (list.size() > 1) {
                    int start = 0;
                    int end = list.size() - 1;
                    while (start < end && Objects.equals(list.get(start), list.get(end))) {
                        start++;
                        end--;
                    }

                    if (start < end) {
                        return false;
                    }
                }
                if (!queue.isEmpty()) {
                    list.clear();
                    queue.add(null);
                }
            } else {
                list.add(node.val);
                if (null == node.left && null != node.right) {
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                    queue.add(node.right);
                }

                if (null != node.left && null == node.right) {
                    queue.add(node.left);
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }

                if (null != node.left && null != node.right) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return true;
    }
}
