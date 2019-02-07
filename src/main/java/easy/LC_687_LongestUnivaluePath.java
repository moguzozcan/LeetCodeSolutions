package easy;

/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may
or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */

public class LC_687_LongestUnivaluePath {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans;

    /*
    Complexity Analysis

    Time Complexity: O(N)O(N), where NN is the number of nodes in the tree. We process every node once.

    Space Complexity: O(H)O(H), where HH is the height of the tree. Our recursive call stack could be up to HH layers deep.
     */
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;

        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);

        int arrowLeft = 0, arrowRigth = 0;

        if(root.left != null && root.val == root.left.val) {
            arrowLeft += left + 1;
        }

        if(root.right != null && root.val == root.right.val) {
            arrowRigth += right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRigth);
        return Math.max(arrowLeft, arrowRigth);
    }

}
