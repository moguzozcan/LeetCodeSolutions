package easy;

/*
Difficulty: Easy
Companies: Facebook

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class LC_404_SumOfLeftLeaves {

    private int sum;

    /*
    Time complexity: O(N) N is the number of nodes
    Space complexity: O(1) do not use extra space, only constant in value
    This is a recursion based approach, it uses stack area of jvm and this can exhaust quickly.
    We can use a iterative approach instead

    Edge cases:
    Null tree
    Only one element - Consider it as left leaf or not?
    All right leaves? return zero
    Can we have negative elements?
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return sumOfLeftLeavesHelper(root, false);
    }

    private int sumOfLeftLeavesHelper(TreeNode root, boolean isLeftLeaf) {

        if(root.left == null && root.right == null) {
            //System.out.println(root.val + "  " + isLeftLeaf);
            return isLeftLeaf ? root.val : 0;
        }

        sum += sumOfLeftLeavesHelper(root.left, true);
        //System.out.println("Root1 is : " + root.val + " Sum is : " + sum);
        sum += sumOfLeftLeavesHelper(root.right, false);

        //System.out.println("Root2 is : " + root.val + " Sum is : " + sum);

        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }

    /*public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }*/

    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
