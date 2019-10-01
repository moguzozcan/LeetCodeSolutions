package easy;

/*
Difficulty: Easy
Companies: Amazon

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
*/

import java.util.HashSet;
import java.util.Set;

public class LC_141_LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * The logic is visit all the nodes and if we have seen a node before means there is a cycle
     * The time complexity is O(N) where N is the number of nodes in the list, space complexity is the same
     * since I store all the elements in a set
     * @param head
     * @return
     */
    public boolean hasCycleHashSetSolution(ListNode head) {
        Set<ListNode> hasSeen = new HashSet<>();

        while (head != null) {
            if(hasSeen.contains(head)) {
                return true;
            } else {
                hasSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * The idea is if we have two pointers and the fast one reached to end then there is no cycle,
     * If fast and slow meet at some point then this means that there is a cycle,
     * Time complexity is O(N)
     * Both pointers are now in the cycle. Consider two runners running in a cycle - the fast runner moves 2 steps while the slow runner moves 1 steps at a time. Since the speed difference is 1, it takes \dfrac{\text{distance between the 2 runners}}{\text{difference of speed}}
     * difference of speed
     * distance between the 2 runners
     * ​
     *   loops for the fast runner to catch up with the slow runner. As the distance is at most "\text{cyclic length K}cyclic length K" and the speed difference is 1, we conclude that
     * \text{Number of iterations} = \text{almost}Number of iterations=almost "\text{cyclic length K}cyclic length K".
     *
     * Therefore, the worst case time complexity is O(N+K)O(N+K), which is O(n)O(n).
     * Space complexity is O(1)
     * @param head
     * @return
     */
    public boolean hasCycleTwoPointers(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}