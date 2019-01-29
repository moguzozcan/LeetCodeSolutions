import easy.LC_4_MedianOfTwoSortedArrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_4_MedianOfTwoSortedArrays_Test {

    private LC_4_MedianOfTwoSortedArrays lc_4_medianOfTwoSortedArrays;


    @Before
    public void init() {
        lc_4_medianOfTwoSortedArrays  = new LC_4_MedianOfTwoSortedArrays();
    }

    @Test
    public void testRegularWithLengthEven() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        double median = lc_4_medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(2.5, median, 0.0001);
    }

    @Test
    public void testRegularWithLengthOdd() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4, 5};

        double median = lc_4_medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(3, median, 0.0001);
    }

    @Test
    public void testRegularWithLengthOne() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double median = lc_4_medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(2, median, 0.0001);
    }

    @Test
    public void testRegularWithLengthEmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {2};

        double median = lc_4_medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(2, median, 0.0001);
    }

    @Test
    public void testRegularWithLengthTwoLengthOneArray() {
        int[] nums1 = {1};
        int[] nums2 = {2};

        double median = lc_4_medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(1.5, median, 0.0001);
    }
}
