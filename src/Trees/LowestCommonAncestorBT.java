package Trees;

public class LowestCommonAncestorBT {

    public static void main(String[] args) {

//
//        System.out.println(lowestCommonAncestor());
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (right == null) {
            return left;
        } else if (left == null) {
            return right;
        } else {
            return root;
        }

    }


    /**
     * if (root == null) {
     *             return null;
     *         }
     *         if (root == p || root == q) {
     *             return root;
     *         }
     *
     *         TreeNode leftSub = lowestCommonAncestor(root.left, p, q);
     *         TreeNode rightSub = lowestCommonAncestor(root.right, p, q);
     *         if (leftSub == null) {
     *             return rightSub;
     *         }
     *         if (rightSub == null) {
     *             return leftSub;
     *         }
     *
     *         return root;
     *
     */
}
