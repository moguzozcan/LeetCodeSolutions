package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant
of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA
definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
 */
public class LC_235_LowestCommonAncestorOfABinarySearchTree {

    /*
    This is a recursive solution for this, we have covered all the possible cases.
    1. If one of the value is smaller than root and the other is larger then return root,
    2. If both values are larger than root, call the method with the right subtree

    Time Complexity: O(N)O(N), where NN is the number of nodes in the BST. In the worst case we might be
    visiting all the nodes of the BST.

    Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack
    would be NN since the height of a skewed BST could be NN.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return p;
        }

        if (q.val == root.val) {
            return q;
        }

        if (p.val < root.val && q.val > root.val) {
            return root;
        } else if (p.val > root.val && q.val < root.val) {
            return root;
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }  //What if there is no solution?

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    Time Complexity : O(N)O(N), where NN is the number of nodes in the BST. In the worst case we might be
    visiting all the nodes of the BST.

    Space Complexity : O(1)O(1)
     */
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        boolean finished = false;

        while (!finished) { //while(root!= null)
            if (p.val < root.val && q.val > root.val) {
                finished = true;
            } else if (p.val > root.val && q.val < root.val) {
                finished = true;  //here we can return root and at the end of while loop we need to return null
                // since there may not be a solution
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
