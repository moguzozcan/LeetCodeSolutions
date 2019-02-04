package easy;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */

import java.util.Arrays;

public class LC_581_ShortestUnsortedContinuousSubarray {

    /*
    Idea is to copy the array to another one and sort the original. Then compare the original with the sorted. If the
    sorted and the original is equal return 0. If not get the begin and end indexes when the difference between the two
    has started and ended.
    The time complexity is O(NlogN) since sorting takes this time.
    The space complexity is O(N) since we are making a copy of the array
     */
    public int findUnsortedSubarray(int[] nums) {

        int[] nums2 = nums.clone();

        Arrays.sort(nums);

        int begin = 0;
        boolean isBegin = false;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums2[i]) {
                if(!isBegin) {
                    begin = i;
                    isBegin = true;
                } else {
                    end = i;
                }
            }
        }

        return !isBegin ? 0 : end - begin + 1;
    }

    /*
    Approach #5 Without Using Extra Space [Accepted]:
    Algorithm
    The idea behind this method is that the correct position of the minimum element in the unsorted subarray helps to
    determine the required left boundary. Similarly, the correct position of the maximum element in the unsorted subarray
    helps to determine the required right boundary.
    Thus, firstly we need to determine when the correctly sorted array goes wrong. We keep a track of this by observing
    rising slope starting from the beginning of the array. Whenever the slope falls, we know that the unsorted array has
     surely started. Thus, now we determine the minimum element found till the end of the array numsnums, given by minmin.

    Similarly, we scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, we
    start looking for the maximum element till we reach the beginning of the array, given by maxmax.

    Then, we traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements
    with the other array elements. e.g. To determine the correct position of minmin, we know the initial portion of
    numsnums is already sorted. Thus, we need to find the first element which is just larger than minmin. Similarly, for
    maxmax's position, we need to find the first element which is just smaller than maxmax searching in numsnums backwards.

    We can take this figure for reference again:
    We can observe that the point bb needs to lie just after index 0 marking the left boundary and the point aa needs to
    lie just before index 7 marking the right boundary of the unsorted subarray.
     */
    public int findUnsortedSubarrayOptimized(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

}
