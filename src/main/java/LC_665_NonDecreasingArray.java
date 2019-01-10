/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
 */

public class LC_665_NonDecreasingArray {

    /*
    This question is just to test if the cases can be understand by the interviewer. There are two cases to consider.
    If the previous element is bigger than the next, we need to change the value. This is obvious, however, we also
    need to check if the two previous element is also bigger than the current element. If this is the case, then
    we need to set the current element to the value of the previous element. If this is not the case, we can just set
    the previous element with the value of the current element to make current element smaller for the future comparison
    If we are at the beginning then we can just set the previous element with the current element, not to increase the
    current element value.

    2 Examples:
    0  ...  i ...
    1 1 2 4[2]5 6  - in this case we can just raise a[i] to 4;
            4
    1 1 2[4]2 3 4  - in this case lower a[i-1] is better;
          2
    */
    public boolean checkPossibility(int[] nums) {
        int numberOfDecreasing = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                if(i == 1 || nums[i - 2] < nums[i]) {
                    nums[i - 1] = nums[i];
                    if(++numberOfDecreasing >= 2) {
                        return false;
                    }
                } else {
                    nums[i] = nums[i - 1];
                    if(++numberOfDecreasing >= 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
