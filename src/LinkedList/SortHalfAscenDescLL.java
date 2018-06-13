package LinkedList;


public class SortHalfAscenDescLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(40);
        head.next.next = new ListNode(53);
        head.next.next.next = new ListNode(30);
        head.next.next.next.next = new ListNode(67);
        head.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next = new ListNode(89);

        printList(head);

        sortList(head);

    }

    private static void sortList(ListNode head) {
        ListNode[] ascdesList = createAscDesc(head);

        ascdesList[1] = reverseList(ascdesList[1]);

        head = mergeList(ascdesList[0], ascdesList[1]);

        printList(head);
    }

    private static ListNode mergeList(ListNode listOne, ListNode listTwo) {
        ListNode head;
        ListNode temp = null;
        if (listOne.getVal() < listTwo.getVal()) {
            head = listOne;
        } else {
            head = listTwo;
        }

        while (listOne != null && listOne.getVal() <= listTwo.getVal()) {
            temp = listOne;
            listOne = listOne.getNext();
        }
        if (temp != null) {
            temp.setNext(listTwo);
        }
        while (listTwo != null && listTwo.getVal() < listOne.getVal()) {
            temp = listTwo;
            listTwo = listTwo.getNext();
        }
        if (temp != null) {
            temp.setNext(listOne);
        }

        return head;
    }

    private static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode ahead = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = ahead;
            if (temp != null) {
                head = temp;
            }
        }
        return head;
    }


    private static ListNode[] createAscDesc(ListNode head) {

        if (head == null) {
            return null;
        } else {
            ListNode asc = head;
            ListNode desc = head.getNext();

            ListNode tempOne = asc;
            ListNode tempTwo = desc;

            while (tempOne != null && tempTwo != null) {
                tempOne.setNext(tempTwo.getNext());
                tempTwo.setNext(tempOne.getNext().getNext());
                tempOne = tempOne.getNext();
                tempTwo = tempTwo.getNext();
            }

            return new ListNode[]{asc, desc};
        }

    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Error");
        } else {
            while (head != null) {
                System.out.print(head.getVal() + " ");
                head = head.getNext();
            }
            System.out.println("");
        }
    }

}
