package easy;

import easy.LC_270_ClosestBinarySearchTreeValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_270_ClosestBinarySearchTreeValue_Test {

    private LC_270_ClosestBinarySearchTreeValue lc_270_closestBinarySearchTreeValue;

    @Before
    public void init() {
        lc_270_closestBinarySearchTreeValue = new LC_270_ClosestBinarySearchTreeValue();
    }

    @Test
    public void closestValueTest() {
        LC_270_ClosestBinarySearchTreeValue.TreeNode treeNode = new LC_270_ClosestBinarySearchTreeValue.TreeNode(1);
        treeNode.left = new LC_270_ClosestBinarySearchTreeValue.TreeNode(3);
        treeNode.right = new LC_270_ClosestBinarySearchTreeValue.TreeNode(2);
        treeNode.left.left = new LC_270_ClosestBinarySearchTreeValue.TreeNode(4);

        double closestValue = lc_270_closestBinarySearchTreeValue.closestValue(treeNode, 3.1d);

        //Assert.assertEquals(0.1, closestValue, 0.001);
    }
}
