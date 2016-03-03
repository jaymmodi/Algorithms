package LinkedList;


public class SortHalfAscenDescLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(40);
        head.next.next = new Node(53);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(67);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(89);

        printList(head);

        sortList(head);

    }

    private static void sortList(Node head) {
        Node[] ascdesList = createAscDesc(head);

        ascdesList[1] = reverseList(ascdesList[1]);

        head = mergeList(ascdesList[0], ascdesList[1]);

        printList(head);
    }

    private static Node mergeList(Node listOne, Node listTwo) {
        Node head;
        Node temp = null;
        if (listOne.getData() < listTwo.getData()) {
            head = listOne;
        } else {
            head = listTwo;
        }

        while (listOne != null && listOne.getData() <= listTwo.getData()) {
            temp = listOne;
            listOne = listOne.getNext();
        }
        if (temp != null) {
            temp.setNext(listTwo);
        }
        while (listTwo != null && listTwo.getData() < listOne.getData()) {
            temp = listTwo;
            listTwo = listTwo.getNext();
        }
        if (temp != null) {
            temp.setNext(listOne);
        }

        return head;
    }

    private static Node reverseList(Node head) {

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node ahead = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = ahead;
            if (temp != null) {
                head = temp;
            }
        }
        return head;
    }


    private static Node[] createAscDesc(Node head) {

        if (head == null) {
            return null;
        } else {
            Node asc = head;
            Node desc = head.getNext();

            Node tempOne = asc;
            Node tempTwo = desc;

            while (tempOne != null && tempTwo != null) {
                tempOne.setNext(tempTwo.getNext());
                tempTwo.setNext(tempOne.getNext().getNext());
                tempOne = tempOne.getNext();
                tempTwo = tempTwo.getNext();
            }

            return new Node[]{asc, desc};
        }

    }

    private static void printList(Node head) {
        if (head == null) {
            System.out.println("Error");
        } else {
            while (head != null) {
                System.out.print(head.getData() + " ");
                head = head.getNext();
            }
            System.out.println("");
        }
    }

}
