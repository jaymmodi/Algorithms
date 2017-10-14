package Trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.left = new TreeNode(4);

        right.left = new TreeNode(2);
        right.left.left = new TreeNode(4);
        right.right = new TreeNode(4);

        root.right = right;
        root.left = left;

        printAllPaths(root);
    }

    public static void printAllPaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        printAllPaths(root, "", paths);

        paths.forEach(System.out::println);
    }

    private static void printAllPaths(TreeNode root, String pathString, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(pathString + root.val);
        } else {
            printAllPaths(root.left, pathString + root.val, paths);
            printAllPaths(root.right, pathString + root.val, paths);

        }
    }


}
