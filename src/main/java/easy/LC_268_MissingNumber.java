package easy;

/*
Difficulty: Easy
Companies: Facebook

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the
array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
complexity?
 */
public class LC_268_MissingNumber {

    public int missingNumberMinusValues(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            if(!(Math.abs(nums[i]) >= nums.length)) {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }
        return 1;
    }


    /**
     * First idea is of course is to sort the array, but sorting is ONlogN times. We need to do it in linear time
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] numsNew = new int[nums.length + 1];

        for(int num : nums) {
            numsNew[num] = 1;
        }

        for(int i = 0; i < numsNew.length; i++) {  //Or we can use a hashset to get in O(1) with contains method
            if(numsNew[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Using bit manipulation, XOR all the elements with the length of the array
     * @param nums
     * @return
     */
    public int missingNumberBitManipulation(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * Using gauss formula which is very easy to implement
     * @param nums
     * @return
     */
    public int missingNumberGaussFormula(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
