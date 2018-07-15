package amazon;

public class Node implements Cloneable {

    Node left;
    Node right;
    int value;

    Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.right = new Node(6);

        System.out.println(node);

        try {
            Object clone = node.clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
