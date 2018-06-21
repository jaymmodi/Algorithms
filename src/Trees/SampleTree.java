package Trees;

public class SampleTree {

    public static TreeNode getBinaryTree() {
        /*

                      1
               2               3
           4      5         5    null
            197         100    2
                            100 null
        
         */


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.right = new TreeNode(197);

        root.right.left = new TreeNode(5);

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
        /*
        *                   1
        *              2         2
        *          3      4    4   3
        *
        *
        * */


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }

    public static TreeNode getBST() {
        /*

                5
            3       6
         2     4       7

         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        return root;
    }

    public static TreeNode getBinaryTree2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);

        return root;
    }
}
