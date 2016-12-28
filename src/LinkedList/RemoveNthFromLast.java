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

        head = removeNthFromLast(head, 1);
        printList(head);
    }

    private static Node removeNthFromLast(Node head, int number) {
        Node fastPointer = head;
        Node slowPointer = head;
        Node previousToSlowPointer = null;

        int fastCount = 1; // start at 1.
        int slowCount = 1;

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            fastCount++;

            if (fastCount - slowCount > number - 1) {   // keep the difference as n - 1
                slowCount++;
                previousToSlowPointer = slowPointer;
                slowPointer = slowPointer.next;
            }
        }

        if (previousToSlowPointer != null) {
            previousToSlowPointer.next = slowPointer.next; // remove nth element
        } else {
            return head.next;
        }

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
