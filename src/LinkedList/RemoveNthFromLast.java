package LinkedList;

import java.util.List;

import static java.util.Arrays.asList;

/***
 * Remove nth node from end of the list -- Leetcode
 */
public class RemoveNthFromLast {

    public static void main(String[] args) {
        Node head = createList(asList(1, 2, 3, 5, 8, 9, 100));
        printList(head);


        head = removeNthFromLast(head, 2);
        printList(head);
    }

    private static Node removeNthFromLast(Node head, int number) {
        Node fastPointer = head;
        Node slowPointer = head;
        Node previousToSlowPointer = head;

        int fastCount = 0;
        int slowCount = 0;

        while (fastPointer.next != null) {
            if (fastCount - slowCount == number) {
                slowCount++;
                previousToSlowPointer = slowPointer;
                slowPointer = slowPointer.next;
            }

            fastCount++;
            fastPointer = fastPointer.next;
        }

        if ((fastCount - slowCount == number)) {
            previousToSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
        }

        previousToSlowPointer.next = slowPointer.next;
        slowPointer.next = null;

        return head;
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

    private static Node createList(List<Integer> integers) {
        Node head = null;
        for (Integer integer : integers) {
            head = addInLinkedList(head, integer);
        }
        return head;
    }

    private static Node addInLinkedList(Node head, Integer integer) {

        if (head == null) {
            return new Node(integer);
        }
        Node first = head;
        while (head.next != null) {
            head = head.next;
        }

        head.next = new Node(integer);
        return first;
    }

}
