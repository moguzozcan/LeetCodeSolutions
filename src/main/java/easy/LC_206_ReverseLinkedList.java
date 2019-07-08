package easy;

/*
Difficulty: Easy
Companies: Facebook

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */


import java.util.ArrayList;
import java.util.List;

public class LC_206_ReverseLinkedList {

    /*
    The first idea is to store all the elements of the linked list into a list, then
    create new linked list by using the list from the end, however this idea is very space
    inefficient. Instead, just revert the next pointer of the current element to the previous.

    1 -> 2 -> 3 -> o
    3 -> 2 -> 1 -> o
    Complexity analysis

    Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).

    Space complexity : O(1)O(1).
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode nextTemp = curr.next;  //This is the critical point not to lose the current next with a tmp
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;   //Because we exit the loop when curr is null, we cannot return null
    }

    /*
    The recursive version is slightly trickier and the key is to work backwards. Assume that the rest of the
    list had already been reversed, now how do I reverse the front part? Let's assume the list is:
    n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
    Assume from node nk+1 to nm had been reversed and you are at node nk.
    n1 → … → nk-1 → nk → nk+1 ← … ← nm
    We want nk+1’s next node to point to nk.
    So,
    nk.next.next = nk;
    Be very careful that n1's next must point to Ø. If you forget about this, your linked list has a cycle in
    it. This bug could be caught if you test your code with a linked list of size 2.
    1 -> 2 -> 3 -> o
    3 -> 2 -> 1 -> o
    Complexity analysis
     */
    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curr;
        curr = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
/*
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        List<Integer> valueList = new ArrayList<>();

        while(head != null) {
            valueList.add(head.val);
            head = head.next;
        }

        ListNode newHead = new ListNode(valueList.get(valueList.size() - 1));
        ListNode curr = null;
        newHead.next = curr;

        for(int i = valueList.size() - 2; i >= 0; i--) {
            curr = new ListNode(valueList.get(i));
            curr
        }

    }*/

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


