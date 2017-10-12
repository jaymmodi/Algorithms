package Trees;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);

        left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        right.right = new TreeNode(7);

        root.right = right;
        root.left = left;

//        inorderTraversal(root).forEach(System.out::print);
        inOrderIterative(root).forEach(System.out::print);
    }

    private static List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        inOrderIterative(root, numbers);
        return numbers;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        inOrder(root, numbers);
        return numbers;
    }

    private static void inOrder(TreeNode root, List<Integer> numbers) {
        if (root == null) {
            return;
        }

        inOrder(root.left, numbers);
        numbers.add(root.val);
        inOrder(root.right, numbers);
    }

    private static void inOrderIterative(TreeNode root, List<Integer> numbers) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        if (root == null) {
            return;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                while (null != currentNode.left) {
                    visited.add(currentNode.left);
                    stack.push(currentNode.left);

                    currentNode = currentNode.left;
                }
            } else {
                currentNode = stack.pop();
                numbers.add(currentNode.val);

                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
        }

    }
}
