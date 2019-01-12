/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
 */

public class LC_747_LargestNumberAtLeastTwiceOfOthers {

    /*
    We need to find the max element and its index and also the second max element. Why because if the second element
    is smaller than half of the max, then we return the index, if not we return -1. The edge cases are,
    - If array has 1 element
    - If the second max is 0
    - If the second max is Integer.MIN_VALUE, which is the same with first case.
    The original solution provided by the leet code is a bit easy and quick
    */

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for(int num : nums) {
            if(num > secondMax && num != max) {
                secondMax = num;
            }
        }
        if(secondMax == 0 || secondMax == Integer.MIN_VALUE || (max / secondMax) >= 2) {
            return index;
        } else {
            return -1;
        }
    }

    /*
    Scan through the array to find the unique largest element m, keeping track of it's index maxIndex.
    Scan through the array again. If we find some x != m with m < 2*x, we should return -1.
    Otherwise, we should return maxIndex.
     */
    public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

}
