package LinkedList;

import java.util.Arrays;

import static LinkedList.SampleLinkedList.printList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode head2 = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4));
        ListNode head3 = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4));
        ListNode head4 = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 4));

        printList(reverseBetween(head, 2, 4));
        printList(reverseBetween(head2, 2, 4));
        printList(reverseBetween(head3, 1, 4));
        printList(reverseBetween(head4, 1, 1));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        if (m == n) {
            return head;
        }

        ListNode start = head;
        ListNode startPrev = null;

        for (int i = 1; i <= m - 1; i++) {
            startPrev = start;
            start = start.next;
        }

        ListNode prev = startPrev;
        ListNode current = start;
        for (int i = 1; i <= n - m + 1; i++) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        start.next = current;
        if (startPrev != null) {
            startPrev.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}
