package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class LC_543_DiameterOfBinaryTree {

    //private int result = 0;

    /*
    The idea in this question is to find the depth of the tree for right and left subtrees. While doing this, also
    create a variable to keep the maximum path between two nodes for each node. This variable holds max depth of the
    left and right subtree. Using an array with length one instead of creating an int variable saves a lot of memory
    in recursive function calls. The int variable is created in every method call while the array will stay as it is.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findDepth(root, diameter);

        return diameter[0];
    }

    public int findDepth(TreeNode root, int[] diameter) {
        if(root == null) {
            return 0;
        }

        int L = findDepth(root.left, diameter);
        int R = findDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], L + R);

        return Math.max(L, R) + 1;
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
