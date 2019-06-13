package easy;

/*
Difficulty: Easy
Companies: Facebook

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class LC_283_MoveZeroes {

    /*
    Time complexity is O(N), space complexity is O(1)
    Test and edge cases:
    leading zeros [0 0 1 2 3]
    leading non zero elements [1 2 0 3]
    negative elements [-1 2 0]
    all zeros [0 0 0 0]   // dont do any swap in these cases
    all non zeros [1 2 3 4]

    But swap is three operations, this can be discussed even further, when see a non zero put it to location of the
    zeros, then fill the array after the last zero index to length with zeros
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int zeroesIndex = 0;

        for(int i = 0; i < len; i++) {
            if(nums[i] != 0) {
                if(i > zeroesIndex)
                    swap(zeroesIndex, i, nums);
                zeroesIndex++;
            }
        }
    }

    private void swap(int zeroesIndex, int i, int[] nums) {
        int tmp = nums[zeroesIndex];
        nums[zeroesIndex] = nums[i];
        nums[i] = tmp;
    }

}
