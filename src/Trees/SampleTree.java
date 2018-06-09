package Trees;

public class SampleTree {

    public static TreeNode getBinaryTree() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        return root;
    }
}
