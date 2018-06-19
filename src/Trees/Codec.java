package Trees;

public class Codec {
    public static void main(String[] args) {
        TreeNode node = SampleTree.getBST();

        Codec codec = new Codec();
        String serialize = codec.serialize(node);

        codec.deserialize(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }

        return serialize(root.left) + root.val + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
