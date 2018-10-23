/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

public class LC_270_ClosestBinarySearchTreeValue {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int currClosest = 0;

        currClosest = closestValue(root, target, currClosest, diff);

        return currClosest;
    }

    private int closestValue(TreeNode root, double target, int currClosest, double diff) {
        if(root == null) {
            return currClosest;
        }

        if(diff > Math.abs(root.val - target)) {
            diff = Math.abs(root.val - target);
            currClosest = root.val;
        }

        currClosest = currClosest > closestValue(root.left, target, currClosest, diff) ? closestValue(root.left, target, currClosest, diff): currClosest;
        currClosest = currClosest > closestValue(root.right, target, currClosest, diff) ? closestValue(root.right, target, currClosest, diff): currClosest;

        return currClosest;
    }

/*
    public int closestValue(TreeNode root, double target) {
        //         Select the root node of the subtree
        TreeNode kid = target < root.val ? root.left : root.right;
        //         If there is no subtree, that is, when recursing to the end, directly return the current node value
        if(kid == null) return root.val;
        // Find the nearest node in the subtree
        int closest = closestValue(kid, target);
        // Returns the node closest to the root node and the nearest node of the subtree
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }


    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while(root!=null){
            //if current root.val is closer, update closest
            closest = Math.abs(closest-target)<Math.abs(root.val-target)?closest:root.val;
            //do binary search
            root = target<root.val?root.left:root.right;
        }
        return closest;
    }*/
}
