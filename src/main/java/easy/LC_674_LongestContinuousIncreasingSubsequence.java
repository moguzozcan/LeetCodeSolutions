package easy;

/*
Difficulty: Easy
Companies: Facebook

Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
Note: Length of the array will not exceed 10,000.
 */
public class LC_674_LongestContinuousIncreasingSubsequence {

    /**
     * Idea is very simple, since every increasing continuous sub array are disjoint
     * we need to store the current max and at the end we need to find the global max value.
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;

        int currMax = 1;
        int max = 1;

        if(len == 0 || len == 1) {
            return len;
        }

        for(int i = 0; i < len - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                currMax++;
            } else {
                if(max < currMax) {
                    max = currMax;
                }
                currMax = 1;
            }
        }
        if(max < currMax) {
            max = currMax;
            currMax = 1;
        }

        return max;
    }
}
