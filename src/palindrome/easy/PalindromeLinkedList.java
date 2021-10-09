package palindrome.easy;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) { // whenever iterating through linked list, fastest pointer is breaking condition
            fast = fast.next.next; // 2 nodes at a time
            slow = slow.next; // 1 node at a time
        }

        slow = reversed(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val)
                return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public static ListNode reversed(ListNode head) {
        ListNode prev = null;

        // 1 -> 2 -> 3
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}

class ListNode {
    int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }