/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note: There are at least two nodes in this BST.
 */

import java.util.ArrayList;
import java.util.List;

public class LC_530_MinimumAbsoluteDifferenceInBST {

    /*
    The logic in this question is to use the power or feature of BST. BST is binary search tree, where the values in
    the left of a node is always smaller than the node and the values in the rigth of the node is always larger or
    equal to the node. In this question, we are trying to find the minimum difference between the nodes. Obviously, this
    min difference can be between two adjacent nodes, assume that these node values are in sorted. Actually they are!
    Because if we traverse the BST in in-order fashion, we get all the values in a sorted way.

    I've solved this question twice, first is 9 months ago and that solution is cleverer :) My current approach is
    to store the node values is a list by traversing the BST in in-order, then look at the differences in adjacents.
    Then we can find the solution, the space complexity is O(N), where N is the number of nodes and time complexity
    is also O(N) since we traverse the BST and also we loop through the list.

    Second more optimized solution in terms of space is, use the previous pointer, which holds the value of the previous
    node in BST, we can store them in a class variable. Then for every node, we can compare them with the current value.
    The time complexity is again O(N), but the space complexity is O(1) now.
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inOrderTraversal(root, list);
        int min = Integer.MAX_VALUE;

        int size = list.size();

        if(size == 2) {
            return list.get(1) - list.get(0);
        } else {
            for(int i = 0; i < list.size() - 1; i++) {
                if(min > list.get(i + 1) - list.get(i)) {
                    min = list.get(i + 1) - list.get(i);
                }
            }
            return min;
        }
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference2(TreeNode root) {
        if(root == null) {
            return min;
        }

        getMinimumDifference2(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        getMinimumDifference2(root.right);

        return min;
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
