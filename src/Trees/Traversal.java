package Trees;

public class Traversal {
    public static void main(String[] args) {
        System.out.println("PreOrder");
        preorder(SampleTree.getBST());
        System.out.println();
        System.out.println("InOrder");
        inorder(SampleTree.getBST());
        System.out.println();
        System.out.println("PostOrder");
        postOrder(SampleTree.getBST());

    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val);
        }
    }
}
