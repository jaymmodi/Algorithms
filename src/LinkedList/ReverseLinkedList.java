package LinkedList;

import java.util.Arrays;

import static LinkedList.SampleLinkedList.printList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode head2 = SampleLinkedList.createList(Arrays.asList(1));
        ListNode head3 = SampleLinkedList.createList(Arrays.asList(1, 1, 1));
        ListNode head4 = SampleLinkedList.createList(Arrays.asList(1, 1, 1, 100));

        printList(reverseList(head));
        printList(reverseList(head2));
        printList(reverseList(head3));
        printList(reverseList(head4));
    }


    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current.next != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;

            current = next;
        }

        current.next = prev;

        return current;
    }
}
