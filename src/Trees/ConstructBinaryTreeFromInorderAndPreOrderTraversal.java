package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreOrderTraversal {
    public static void main(String[] args) {
        int[] inorder = {3,2,1};
        int[] preorder = {3,2,1};

//        int[] inorder = {9, 3, 15, 20, 7};
//        int[] preorder = {3, 9, 20, 15, 7};

        TreeNode root = buildTree(inorder, preorder);
        Traversal.inorder(root);
        System.out.println();
        Traversal.preorder(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        if (inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        int preIndex = 0;
        int inIndex = inOrderIndexMap.get(preorder[preIndex]);
        return buildTreeHelper(inorder, preorder, 0, inorder.length - 1, inIndex, preIndex, inOrderIndexMap);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] preorder, int start, int end, int inIndex, int preIndex, Map<Integer, Integer> inOrderIndexMap) {
        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        if (start < end) {
            TreeNode root = new TreeNode(preorder[preIndex]);

            if (start < inIndex) {
                int nextPreIndex = preIndex + 1;
                int nextinIndex = inOrderIndexMap.get(preorder[nextPreIndex]);

                root.left = buildTreeHelper(inorder, preorder, start, inIndex - 1, nextinIndex, nextPreIndex, inOrderIndexMap);
            }

            if (inIndex < end) {
                int number = inIndex - start + 1;
                int nextPreIndex = preIndex + number;
                int nextinIndex = inOrderIndexMap.get(preorder[nextPreIndex]);

                root.right = buildTreeHelper(inorder, preorder, inIndex + 1, end, nextinIndex, nextPreIndex, inOrderIndexMap);
            }
            return root;
        } else {
            return null;
        }
    }
}
