/*
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_783_MinimumDistanceBetweenBSTNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    The idea is get all the elements from the BST, and store it in a list, then sort, of no need to sort if the values
    are obtained in in-order fashion, since BST itself is sorted. Then we can look for the minimum difference between
    the adjacent nodes.
    The time complexity is O(N), the recursion, and the space complexity is also O(N), since we store the tree in a
    list and then loop through it.
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root, list);

        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < minDiff) {
                minDiff = list.get(i + 1) - list.get(i);
            }
        }

        return minDiff;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    /*
    We can decrease the space complexity a bit by not using a list that stores the whole BST and store the prev value,
    and also the minDiff value. The time complexity is O(N), space complexity is O(1), which is better than the previous
    solution
     */
    public int minDiffInBSTDiffComplexity(TreeNode root) {

        if(root.left !=null) {
            minDiffInBSTDiffComplexity(root.left);
        }

        if(prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;

        if(root.right != null) {
            minDiffInBSTDiffComplexity(root.right);
        }

        return minDiff;
    }

}
