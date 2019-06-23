package medium;

/*
Difficulty: Medium
Companies: Facebook

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets
in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();

        //Sort the array
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            //How to ensure uniqueness      -3 -3 -2 -2 -1 -1 0 1 1 2 3 3 4 5 5 6

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int rem = 0 - nums[i];
            searchForRemaining(i, rem, nums, returnList);
        }

        return returnList;
    }

    private void searchForRemaining(int i, int rem, int[] nums, List<List<Integer>> returnList) {
        int start = i + 1;
        int end = nums.length - 1;
        while(start < end) {
            int curr = rem - (nums[start] + nums[end]);
            if(curr == 0) {
                List<Integer> triple = new ArrayList<>();
                triple.add(nums[i]);
                triple.add(nums[start]);
                triple.add(nums[end]);
                returnList.add(triple);

                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) start++;  // skip same result
                while (start < end && nums[end] == nums[end + 1]) end--;  // skip same result
            } else if(curr > 0) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        LC_15_3Sum lc_15_3Sum = new LC_15_3Sum();
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(lc_15_3Sum.threeSum(arr));
    }
}
