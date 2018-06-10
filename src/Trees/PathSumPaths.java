package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumPaths {

    public static void main(String[] args) {
        TreeNode root = SampleTree.getBinaryTree();

        System.out.println(pathSum(root, 204));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> currentList = new ArrayList<>();
        hasPathSumHelper(root, sum, result, currentList);

        return result;
    }

    private static void hasPathSumHelper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            currentList.add(root.val);
            List<Integer> copy = new ArrayList<>(currentList);
            result.add(copy);
            currentList.remove(currentList.size() - 1);
        }

        currentList.add(root.val);
        hasPathSumHelper(root.left, sum - root.val, result, currentList);
        hasPathSumHelper(root.right, sum - root.val, result, currentList);
        currentList.remove(currentList.size() - 1);
    }
}
