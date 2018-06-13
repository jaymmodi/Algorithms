package LinkedList;

import static LinkedList.SampleLinkedList.createList;
import static LinkedList.SampleLinkedList.printList;
import static java.util.Arrays.asList;

/***
 * Remove nth node from end of the list -- Leetcode
 */
public class RemoveNthFromLast {

    public static void main(String[] args) {
        ListNode head = createList(asList(1, 2, 3, 5, 8, 9, 100));
        printList(head);

        head = removeNthFromLast(head, 1);
        printList(head);
    }

    private static ListNode removeNthFromLast(ListNode head, int number) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode previousToSlowPointer = null;

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

}
