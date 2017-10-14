package Trees;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateSubtrees {
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
        List<TreeNode> allTreeNodes = new ArrayList<>();
        List<TreeNode> result = new ArrayList<>();

        inOrderTraversal(root, allTreeNodes);

        for (int i = 0; i < allTreeNodes.size(); i++) {
            TreeNode outerNode = allTreeNodes.get(i);

            for (int j = i + 1; j < allTreeNodes.size(); j++) {
                TreeNode innerNode = allTreeNodes.get(j);
                if (isDuplicate(outerNode, innerNode)) {
                    result.add(outerNode);
                }
            }
        }

        return result;
    }

    private static boolean isDuplicate(TreeNode outerNode, TreeNode innerNode) {
        if (outerNode == null && innerNode == null) {
            return true;
        }
        if (outerNode == null || innerNode == null) {
            return false;
        }

        if (outerNode.val != innerNode.val) {
            return false;
        }

        return isDuplicate(outerNode.left, innerNode.left) && isDuplicate(outerNode.right, innerNode.right);
    }

    private static void inOrderTraversal(TreeNode root, List<TreeNode> allTreeNodes) {
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.left, allTreeNodes);
            allTreeNodes.add(root);
            inOrderTraversal(root.right, allTreeNodes);
        }
    }
}
