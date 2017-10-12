package Trees;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);

        left.left = (new TreeNode(2));
        left.right = (new TreeNode(4));

        right.right = (new TreeNode(7));

        root.right = (right);
        root.left = (left);

        System.out.println(findTarget(root, 9));
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> numbers = new ArrayList<>();
        inOrder(root, numbers);

        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            if (numbers.get(left) + numbers.get(right) == k) {
                return true;
            } else if (numbers.get(left) + numbers.get(right) > k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    private static void inOrder(TreeNode root, List<Integer> numbers) {
        if (root == null) {
            return;
        }

        inOrder(root.left, numbers);
        numbers.add(root.val);
        inOrder(root.right, numbers);
    }
}
