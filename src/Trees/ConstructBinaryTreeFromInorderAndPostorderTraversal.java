package Trees;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
//        int[] inorder = {4, 8, 3, 1, 5, 2};
//        int[] postorder = {4, 3, 8, 5, 2, 1};

        int[] inorder = {3, 2, 1};
        int[] postorder = {3, 2, 1};

        TreeNode root = buildTree(inorder, postorder);
        Traversal.inorder(root);
        System.out.println();
        Traversal.postOrder(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        int postIndex = postorder.length - 1;
        int inIndex = find(inorder, postorder[postIndex]);
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, inIndex, postIndex);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end, int inIndex, int postIndex) {
        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        if (start < end) {
            TreeNode root = new TreeNode(postorder[postIndex]);

            if (start < inIndex) {
                int number = end - inIndex + 1;
                int nextpostIndex = postIndex - number;
                int nextinIndex = find(inorder, postorder[nextpostIndex]);

                root.left = buildTreeHelper(inorder, postorder, start, inIndex - 1, nextinIndex, nextpostIndex);
            }

            if (inIndex < end) {
                int nextpostIndex = postIndex - 1;
                int nextinIndex = find(inorder, postorder[nextpostIndex]);

                root.right = buildTreeHelper(inorder, postorder, inIndex + 1, end, nextinIndex, nextpostIndex);
            }
            return root;
        } else {
            return null;
        }
    }

    private static int find(int[] array, int value) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return index;
    }
}
