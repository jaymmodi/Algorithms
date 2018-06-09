package Trees;

public class SampleTree {

    public static TreeNode getBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(100);
        root.right.left.left = new TreeNode(100);
        root.right.left.right = new TreeNode(2);
        root.right.left.right.left = new TreeNode(100);

        return root;
    }

    public static TreeNode getBinaryTree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        root.left.left.left = null;
        root.left.left.right = null;

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left.left = null;
        root.right.left.right = null;

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);

        return root;
    }

    public static TreeNode getSymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }
}
