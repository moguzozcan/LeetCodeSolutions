package hard;

/*
Difficulty: Hard
Lists: Amazon

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_23_MergeKSortedList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        int len = lists.length;

        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ListNode node = lists[i];

            while(node != null) {
                allNumbers.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(allNumbers);

        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for(int i = 0; i < allNumbers.size(); i++) {
            ListNode next = new ListNode(allNumbers.get(i));
            tmp.next = next;
            tmp = next;
        }
        return head.next;
    }

}
