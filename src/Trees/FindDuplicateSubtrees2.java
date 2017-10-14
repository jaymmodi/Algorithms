package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.left = new TreeNode(4);

        right.left = new TreeNode(2);
        right.left.left = new TreeNode(4);
        right.right = new TreeNode(4);

        root.right = right;
        root.left = left;

        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(root);

        for (TreeNode duplicateSubtree : duplicateSubtrees) {
            System.out.println(duplicateSubtree.val);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        postOrder(root, result, new HashMap<>());
        return result;
    }

    private static String postOrder(TreeNode root, List<TreeNode> result, HashMap<String, Integer> dictionary) {
        if (root == null) {
            return "#";
        }

        String subtree = root.val + postOrder(root.left, result, dictionary) + postOrder(root.right, result, dictionary);
        if (dictionary.containsKey(subtree)) {
            int value = dictionary.get(subtree);
            if (value == 1) {
                result.add(root);
            }
            dictionary.put(subtree, ++value);
        } else {
            dictionary.put(subtree, 1);
        }

        return subtree;
    }
}
