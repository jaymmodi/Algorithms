package Trees;

public class TrimBST {
    public static void main(String[] args) {
        TreeNode root = SampleTree.getBST();

        TreeNode x = trimBST(root, 8, 10);
        System.out.println(x);
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
