package easy;

/*
Difficulty: Easy
Companies: Facebook

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */

public class LC_88_MergeSortedArray {

    /**
     * Idea is to start from the end of the first array where we have empty places and put the elements there
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*if(m - n < 0) {  //edge case
            return;
        }*/

        int index = m + n;

        while(m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[index - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[index - 1] = nums2[n - 1];
                n--;
            }
            index--;
        }

        while(n > 0) {
            nums1[index - 1] = nums2[n - 1];
            n--;
            index--;
        }
    }
}
