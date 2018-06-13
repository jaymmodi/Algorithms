package LinkedList;

import java.util.Arrays;

import static LinkedList.SampleLinkedList.createList;
import static LinkedList.SampleLinkedList.printList;

public class RemoveNode {

    public static void main(String[] args) {
        ListNode head = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4, 4, 4));
        ListNode head2 = SampleLinkedList.createList(Arrays.asList(1, 2, 2, 1, 3, 1, 4, 4, 4));
        ListNode head3 = createList(Arrays.asList(1, 1));

        ListNode x = removeElements(head, 4);
        ListNode y = removeElements(head2, 1);
        ListNode z = removeElements(head3, 1);

        printList(x);
        System.out.println("----");
        printList(y);
        System.out.println("----");
        printList(z);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode prev = null;

        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            prev = head;
            head = head.next;
            current = head;
        }

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }

            current = current.next;
        }
        return head;
    }
}
