package Trees;

public class SerializeDeserializeBinaryTreeII {
    public static void main(String[] args) {
        TreeNode node = SampleTree.getBinaryTree2();

        SerializeDeserializeBinaryTreeII codec = new SerializeDeserializeBinaryTreeII();
        String serialize = codec.serialize(node);
        System.out.println("serialize = " + serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || data.equals("#")) {
            return null;
        }

        String values[] = data.split(",");
        return deserializeHelper(values, 0);
    }

    private TreeNode deserializeHelper(String[] values, int index) {
        if (values[index].equals("#")) {
            ++index;
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(values[index]));
        ++index;
        current.left = deserializeHelper(values, index);
        current.right = deserializeHelper(values, index);

        return current;
    }
}
