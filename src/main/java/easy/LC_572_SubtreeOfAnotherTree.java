package easy;

/*
Difficulty: Easy
Companies: Facebook

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s
could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
public class LC_572_SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();
        traverseTree(s, sbs);
        String sStr = sbs.toString();
        traverseTree(t, sbt);
        String tStr = sbt.toString();

        return sStr.contains(tStr);
    }

    private void traverseTree(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#l");  //to distinguish leaf nodes
            return;
        }

        sb.append("#" + node.val);  //To distinguish each node
        traverseTree(node.left, sb);
        traverseTree(node.right, sb);
    }

    public boolean isSubtreeRecursive(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if(isSameTrees(s, t)) {
            return true;
        }

        return isSubtreeRecursive(s.left, t) || isSubtreeRecursive(s.right, t);
    }

    private boolean isSameTrees(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }

        if(s == null || t == null) {
            return false;
        }

        if(s.val != t.val) {
            return false;
        }
        return isSameTrees(s.left, t.left) && isSameTrees(s.right, t.right);
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
