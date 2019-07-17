package medium;

/*
Difficulty: Medium
Companies: Facebook

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class LC_98_ValidateBinarySearchTree {
    /*
    We need to check if every element is in the
    limits defined by the root node. Every element
    in the left should be less than the root node
    and every element in the right should be bigger
    than the root node.
    */
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return helper(root, null, null);

    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.val <= min) {
            return false;
        }

        if(max != null && root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

