package easy;

import java.util.*;

/*
Difficulty: Easy
Companies: Facebook

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class LC_653_TwoSum4InputIsABST {

    /**
     * The first solution is use a set, and add all the elements to a set,
     * While traversing the tree look if the remaining value is exists on the set, if not
     * add the current element to set, if yes then return true.
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet = new HashSet<>();

        return traverseTree(root, hashSet, k);
    }

    private boolean traverseTree(TreeNode root, Set<Integer> hashSet, int k) {
        if(root == null) {
            return false;
        }
        if(hashSet.contains(k - root.val)) {
            return true;
        }
        hashSet.add(root.val);

        return traverseTree(root.left, hashSet, k) ||         traverseTree(root.right, hashSet, k);
    }

    /**
     * Second solution is very similar to the first one, except it uses BFS not DFS for the seach,
     * the time and space complexities are the same for the first one.
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTargetDFS(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> valueSet = new HashSet<>();

        if(root == null) {
            return false;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();

            if(valueSet.contains(k - tmpNode.val)) {
                return true;
            } else {
                valueSet.add(tmpNode.val);
            }

            if(tmpNode.left != null) {
                queue.add(tmpNode.left);
            }

            if(tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
        return false;
    }

    /**
     * This algorithm uses the BST feature. The inorder traversal of the BST gives the values as array
     * in ascending order. After we obtain the array we can search for the values using two pointers
     * one start from beginning and one start from the end.
     * @param root
     * @param k
     * @return
     */
    public boolean findTargetBST(TreeNode root, int k) {

        if(root == null) {
            return false;
        }
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        int begin = 0;
        int end = values.size() - 1;
        while(begin < end) {
            if(values.get(begin) + values.get(end) == k) {
                return true;
            } else if(values.get(begin) + values.get(end) < k) {
                begin++;
            } else {
                end--;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> values) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
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