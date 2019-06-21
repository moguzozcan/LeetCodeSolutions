package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class LC_234_PalindromeLinkedList {

    /**
     * O(N) time and space complexity where N is the length of the linkedlist
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while(head != null)  {
            sb.append(head.val);
        }

        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * The main idea here is that, find the middle of the list, then reverse that part, and compare it with the
     * first half of the list by starting from the head again. This is a good idea a bit hard to implement and have
     * very critical edge cases
     * @param head
     * @return
     */
    public boolean isPalindromeO1Space(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
