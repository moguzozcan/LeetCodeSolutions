import easy.LC_1_TwoSum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_1_TwoSum_Test {

    private LC_1_TwoSum lc_1_twoSum;

    @Before
    public void init() {
        lc_1_twoSum = new LC_1_TwoSum();
    }

    @Test
    public void testRegularly() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        int[] resArr = lc_1_twoSum.twoSum(nums, target);

        Assert.assertEquals(resArr[0], 1);
        Assert.assertEquals(resArr[1], 0);
    }
}
