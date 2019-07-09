package easy;

/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest
to the target.

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

    int goal;
    double min = Double.MAX_VALUE;

    public int closestValueRecursive(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }

    public void helper(TreeNode root, double target){
        if(root==null)
            return;

        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        }

        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
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

    /**
     * The idea is to search for the value in the BST and also keep the min value found until the nodes.
     * Then check for the value of the searched value if it is smaller than the current node, continue from the
     * left subtree of the node, else otherwise. If the value is equal to the target, then we finished.
     * The result is 0. This is the iterative approach and Time complexity is O(N) where N is the number of
     * nodes in the BST, and Space complexity is O(1). If BST is evenly distributed, then the complexity is
     * O(log(N)), height of the tree.
     * @param root
     * @param target
     * @return
     */
    public int closestValueIterative(TreeNode root, double target) {

        int closest = root.val;
        double min = Double.MAX_VALUE;

        while(root!=null) {
            if( Math.abs(root.val - target) < min  ) {
                min = Math.abs(root.val - target);
                closest = root.val;
            }

            if(target < root.val) {
                root = root.left;
            } else if(target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }

        return closest;
    }

    /**
     * Same as the upper one, but this one continues to search if it finds the 0 value.
     * @param root
     * @param target
     * @return
     */
    public int closestValueABitWorseIterative(TreeNode root, double target) {
        if (root == null) return 0;
        int min = root.val;
        while (root != null) {
            min = (Math.abs(root.val - target) < Math.abs(min - target) ? root.val : min);
            root = (root.val < target) ? root.right : root.left;
        }
        return min;
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
