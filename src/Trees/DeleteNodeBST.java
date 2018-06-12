package Trees;

public class DeleteNodeBST {

    public static void main(String[] args) {
        TreeNode root = SampleTree.getBST();
        inorder(root);

        TreeNode x = deleteNode(root, 3);
        System.out.println("after deleting");
        inorder(x);
    }

    private static void inorder(TreeNode x) {
        if (x != null) {
            inorder(x.left);
            System.out.println(x.val);
            inorder(x.right);
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // case leaf
            if (null == root.left && null == root.right) {
                root = null;
            }
            // case one child
            else if (null == root.left) {
                root = root.right;
            } else if (null == root.right) {
                root = root.left;
            } else {
                // case node has two children
                TreeNode node = findMin(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
