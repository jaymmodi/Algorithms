package LinkedList;


public class CLLImplementation {


    public static void main(String[] args) {
        CLLNode headNode = new CLLNode(5);

        CLLNode one = new CLLNode(1);
        CLLNode two = new CLLNode(2);
        CLLNode three = new CLLNode(3);
        CLLNode four = new CLLNode(4);

        insertCircularList(headNode, one);
        insertCircularList(headNode, two);
        insertCircularList(headNode, three);
        insertCircularList(headNode, four);
    }

    private static void insertCircularList(CLLNode headNode, CLLNode nodeToInsert) {
        if (headNode == null) {
            System.out.println("cannot");
        } else {
            CLLNode currentNode = headNode.getNext();

            if (currentNode == null) {
                System.out.println("FirstNode");
                headNode.setNext(headNode);
                System.out.println(headNode.getData());
            } else {
                while (currentNode != headNode) {
                    currentNode = currentNode.getNext();
                    System.out.println(currentNode.getData());
                }

                currentNode.setNext(nodeToInsert);
                nodeToInsert.setNext(headNode);
            }
        }
    }
}
