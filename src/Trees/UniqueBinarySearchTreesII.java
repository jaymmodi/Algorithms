package Trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        System.out.println(generateTrees(3).size());
    }

    public static List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> memory = new ArrayList<>(n - 1);
        List<TreeNode> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        TreeNode root = new TreeNode(1);
        result.add(root);
        memory.add(result);

        if (n > 1) {
            generateTressHelper(n, memory);
        }

        return memory.get(n - 1);
    }

    private static List<TreeNode> generateTressHelper(int n, List<List<TreeNode>> memory) {
        if (n == 0) {
            List<TreeNode> zero = new ArrayList<>();
            zero.add(null);
            return zero;
        }
        if (n <= memory.size() && memory.get(n - 1) != null) {
            return memory.get(n - 1);
        } else {
            List<TreeNode> treeNodes = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                List<TreeNode> leftSubtrees = generateTressHelper(i - 1, memory);
                List<TreeNode> originalSubtrees = generateTressHelper(n - i, memory);
                List<TreeNode> rightSubtrees = replaceNumbers(originalSubtrees, i);

                for (TreeNode leftSubtree : leftSubtrees) {
                    for (TreeNode rightSubtree : rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftSubtree;
                        root.right = rightSubtree;

                        treeNodes.add(root);
                    }
                }

            }
            memory.add(n - 1, treeNodes);
            return treeNodes;
        }
    }

    private static List<TreeNode> replaceNumbers(List<TreeNode> originalSubtrees, int difference) {
        List<TreeNode> rightSubTrees = new ArrayList<>();

        for (TreeNode originalTree : originalSubtrees) {
            rightSubTrees.add(copy(originalTree, difference));
        }

        return rightSubTrees;
    }

    private static TreeNode copy(TreeNode originalTree, int difference) {
        if (originalTree == null) {
            return null;
        }

        TreeNode root = new TreeNode(originalTree.val + difference);
        root.left = copy(originalTree.left, difference);
        root.right = copy(originalTree.right, difference);

        return root;
    }

}
