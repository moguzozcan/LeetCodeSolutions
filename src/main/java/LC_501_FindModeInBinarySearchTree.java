package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

public class LC_501_FindModeInBinarySearchTree {


    public int[] findMode(TreeNode root) {
        List<Integer> mostOccuredList = new ArrayList<>();

        Map<Integer, Integer> hashMap = new HashMap<>();

        if(root == null) {
            mostOccuredList.toArray();
        } else {
            traverseTree(root, hashMap);
        }

        int max = 0;

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
            }
        }

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(max == entry.getValue()) {
                mostOccuredList.add(entry.getKey());
            }
        }

        return mostOccuredList.stream().mapToInt(i->i).toArray();
    }

    private void traverseTree(TreeNode root, Map<Integer, Integer> hashMap) {
        if(root == null) {
            return;
        }

        if(hashMap.containsKey(root.val)) {
            hashMap.put(root.val, hashMap.get(root.val) + 1);
        } else {
            hashMap.put(root.val, 1);
        }

        traverseTree(root.left, hashMap);
        traverseTree(root.right, hashMap);
    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
