package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        TreeNode node = SampleTree.getBinaryTree2();

        Codec codec = new Codec();
        String serialize = codec.serialize(node);
        System.out.println("serialize = " + serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null == node) {
                sb.append("#");
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.append(",");
        }

        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }

        String[] values = data.split(",");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        nodes.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode currentNode = nodes.poll();

            if (!values[i].equals("#")) {
                currentNode.left = new TreeNode(Integer.parseInt(values[i]));
                nodes.add(currentNode.left);
            }
            if (!values[++i].equals("#")) {
                currentNode.right = new TreeNode(Integer.parseInt(values[i]));
                nodes.add(currentNode.right);
            }
        }


        return root;
    }
}
