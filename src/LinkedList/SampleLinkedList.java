package LinkedList;

import java.util.List;

public class SampleLinkedList {

    public static ListNode createList(List<Integer> integers) {
        ListNode head = null;
        for (Integer integer : integers) {
            head = addInLinkedList(head, integer);
        }
        return head;
    }

    private static ListNode addInLinkedList(ListNode head, Integer integer) {

        if (head == null) {
            return new ListNode(integer);
        }
        ListNode first = head;
        while (head.next != null) {
            head = head.next;
        }

        head.next = new ListNode(integer);
        return first;
    }

    public static void printList(ListNode head) {
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
