package hard;

/*
Difficulty: Hard
Lists: Top Google

Question:
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */


public class LC_4_MedianOfTwoSortedArrays {

    /**
     * Idea is to merge two arrays and then find the median in the merged array,
     * If there are even number of elements in the merged array, then get the middle ones and
     * divide their sum to 2. If there are odd elements then get the middle element and this is your median
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        //Merge two sorted arrays,
        int[] mergeArr = new int[len1 + len2];

        int i1 = 0;
        int i2 = 0;
        int k = 0;
        while(i1 < len1 && i2 < len2) {
            if(nums1[i1] <= nums2[i2]) {
                mergeArr[k] = nums1[i1];
                i1++;
            } else {
                mergeArr[k] = nums2[i2];
                i2++;
            }
            k++;
        }

        if(i1 == len1) {
            while(k < mergeArr.length) {
                mergeArr[k++] = nums2[i2++];
            }
        } else {
            while(k < mergeArr.length) {
                mergeArr[k++] = nums1[i1++];
            }
        }
        return (k % 2) == 0 ? (mergeArr[(k / 2) - 1] + mergeArr[k / 2]) / 2.0 : mergeArr[(k / 2)];
    }
}
