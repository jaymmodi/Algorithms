package Trees;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode t1 = SampleTree.getSymmetricTree();
        TreeNode t2 = SampleTree.getBST();

        TreeNode x = mergeTrees(t1, t2);
        System.out.println(x);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        if (null != t1 && null == t2) {
            return t1;
        }

        if (null == t1 && null != t2) {
            return t2;
        }

        if (null != t1 && null != t2) {
            t1.val += t2.val;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
