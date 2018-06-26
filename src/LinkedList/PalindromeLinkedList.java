package LinkedList;

import java.util.Arrays;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = SampleLinkedList.createList(Arrays.asList(1));
        ListNode head2 = SampleLinkedList.createList(Arrays.asList(1, 2));
        ListNode head3 = SampleLinkedList.createList(Arrays.asList(1, 1));
        ListNode head4 = SampleLinkedList.createList(Arrays.asList(1, 1, 1));
        ListNode head5 = SampleLinkedList.createList(Arrays.asList(1, 2, 1));
        ListNode head6 = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 1));
        ListNode head7 = SampleLinkedList.createList(Arrays.asList(1, 2, 3, 2, 1, 6));

        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome(head2));
        System.out.println(isPalindrome(head3));
        System.out.println(isPalindrome(head4));
        System.out.println(isPalindrome(head5));
        System.out.println(isPalindrome(head6));
        System.out.println(isPalindrome(head7));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // find mid of LL with two pointers

        while (slow != null && fast != null) {
            if (fast.next == null) {
                fast = null;
            } else if (fast.next.next == null) {
                fast = null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        ListNode secondHead = slow.next;

        // reverse the second half
        ListNode reverseHalf = reverseList(secondHead);

        // iterate from both ends


        while (reverseHalf != null) {
            if (reverseHalf.val != head.val) {
                return false;
            }

            reverseHalf = reverseHalf.next;
            head = head.next;
        }

        return true;
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
