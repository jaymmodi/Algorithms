package Trees;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p = SampleTree.getBinaryTree();
        TreeNode q = SampleTree.getBinaryTree();
        q.val = 100;

        System.out.println(isSameTree(p, q));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
