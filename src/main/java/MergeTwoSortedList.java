public class MergeTwoSortedList {

  public static void main(String[] args) {

  }

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   * Input: 1->2->4, 1->3->4
   * Output: 1->1->2->3->4->4
   */
  class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }

      ListNode lHead = new ListNode();
      if(l1.val > l2.val) {
        lHead.val = l2.val;
        l2 = l2.next;
      } else {
        lHead.val = l1.val;
        l1 = l1.next;
      }
      ListNode lCurr = new ListNode();
      lHead.next = lCurr;

      while(l1.next != null && l2.next != null) {

          if(l1.val == l2.val) {
            lCurr.val = l1.val;
            lCurr.next = new ListNode(l2.val);
          } else if (l1.val > l2.val) {
            lCurr.val = l2.val;
            lCurr.next = new ListNode();
          } else {
            lCurr.val = l1.val;
            lCurr.next = new ListNode();
          }

          l2 = l2.next;
          l1 = l1.next;
      }

      if(l1.next == null) {
        while (l2.next != null) {
          lCurr.val = l2.val;
          lCurr.next = new ListNode();
          l2 = l2.next;
        }
      }
      return lHead;
    }
  }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {  }
      ListNode(int x) { val = x; }
   }

}
