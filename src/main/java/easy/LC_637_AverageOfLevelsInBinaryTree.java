package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Difficulty: Easy
Companies: Facebook

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class LC_637_AverageOfLevelsInBinaryTree {

    /*
    The first idea is to use a BFS and then calculate the average for each level and add it to list and return the list
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        //What if tree is null? return null list?
        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //To distinguish each level of the tree
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                total += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            averages.add(total / size);
            total = 0;
        }
        return averages;
    }

    /**
     * This question can also be solved with BFS method
     */
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        BFS(root, 0, sums, counts);

        for(int i = 0; i < sums.size(); i++) {
            sums.set(i, sums.get(i) / counts.get(i));
        }
        return sums;
    }

    private void BFS(TreeNode root, int level, List<Double> sum, List<Integer> count) {
        if(root == null) {
            return;
        }

        if(level < sum.size()) {
            sum.set(level, sum.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(1.0 * root.val);
            count.add(1);
        }

        BFS(root.left, level + 1, sum, count);
        BFS(root.right, level + 1, sum, count);

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
