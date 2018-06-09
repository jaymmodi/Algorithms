package Trees;

public class Size {
    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();

        System.out.println(size(root));
    }

    public static int size(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }
}
