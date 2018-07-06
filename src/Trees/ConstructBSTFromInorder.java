package Trees;

import static Trees.Traversal.inorder;

public class ConstructBSTFromInorder {

    public static void main(String[] args) {
        String inOrderString = "2,3,4,5,6,7,8";

        TreeNode root = makeTree(inOrderString);
        inorder(root);
    }

    private static TreeNode makeTree(String inOrderString) {
        if (inOrderString.isEmpty()) {
            return null;
        }

        return makeTreeHelper(inOrderString.split(","), 0, inOrderString.split(",").length - 1);
    }

    private static TreeNode makeTreeHelper(String[] inOrderString, int start, int end) {
        if (start <= end) {
            if (start == end) {
                int val = Integer.parseInt(inOrderString[start]);
                return new TreeNode(val);
            }

            int mid = start + (end - start) / 2;
            int rootVal = Integer.parseInt(inOrderString[mid]);
            TreeNode root = new TreeNode(rootVal);

            root.left = makeTreeHelper(inOrderString, start, mid - 1);
            root.right = makeTreeHelper(inOrderString, mid + 1, end);

            return root;
        } else {
            return null;
        }

    }
}
