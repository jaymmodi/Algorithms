package Trees;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3Efficient {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.right = new TreeNode(3);

        right.right = new TreeNode(1);

        root.right = right;
        root.left = left;

        System.out.println(rob(root, new HashMap<>()));
    }

    public static int rob(TreeNode root, Map<TreeNode, Integer> memory) {
        if (root == null) return 0;

        if (memory.containsKey(root)) {
            return memory.get(root);
        } else {
            int sum = 0;

            if (root.left != null) {
                sum += rob(root.left.left, memory) + rob(root.left.right, memory);
            }

            if (root.right != null) {
                sum += rob(root.right.left, memory) + rob(root.right.right, memory);
            }

            int result = Math.max(root.val + sum, rob(root.right, memory) + rob(root.left, memory));
            memory.put(root, result);
            return result;
        }

    }

}
