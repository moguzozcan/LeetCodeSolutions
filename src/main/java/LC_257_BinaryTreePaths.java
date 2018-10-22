import java.util.ArrayList;
import java.util.List;

public class LC_257_BinaryTreePaths {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> nodeVals = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        binaryTreePaths(root, paths, nodeVals);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, List<String> paths, List<Integer> nodeVals) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            nodeVals.add(root.val);
            paths.add(convertToFormat(nodeVals));
            nodeVals.remove(nodeVals.size() - 1);
            return;
        }

        nodeVals.add(root.val);
        binaryTreePaths(root.left, paths, nodeVals);
        nodeVals.remove(nodeVals.size() - 1);

        nodeVals.add(root.val);
        binaryTreePaths(root.right, paths, nodeVals);
        nodeVals.remove(nodeVals.size() - 1);
    }

    private String convertToFormat(List<Integer> l) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : l) {
            sb.append(i);
            sb.append("->");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

/* Solution from the discussions
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null) {
            helper(root, "", list);
        }

        return list;
    }

    private void helper(TreeNode root, String path, List<String> list) {
        if (root.left == null && root.right == null)
            list.add(path + root.val);

        if (root.left != null)
            helper(root.left, path + root.val + "->", list);

        if (root.right != null)
            helper(root.right, path + root.val + "->", list);
    }
}
 */