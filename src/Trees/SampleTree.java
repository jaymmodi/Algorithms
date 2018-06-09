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
}
