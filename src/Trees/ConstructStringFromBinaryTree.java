package Trees;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = SampleTree.getBinaryTree2();

        System.out.println(tree2str(treeNode));
    }

    public static String tree2str(TreeNode t) {
        if (null == t) {
            return "";
        }

        if (null == t.left && null == t.right) {
            return "" + t.val;
        }

        String leftTree = tree2str(t.left);
        String rightTree = tree2str(t.right);

        if (!leftTree.isEmpty()) {
            leftTree = "(" + leftTree + ")";
        } else {
            leftTree = "()";
        }

        if (!rightTree.isEmpty()) {
            rightTree = "(" + rightTree + ")";
        } else {
            rightTree = "";
        }


        return "" + t.val + leftTree + rightTree;
    }
}
