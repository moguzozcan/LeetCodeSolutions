package easy;/*
Difficulty: Easy
Companies: Facebook

Question:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */


import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        //Fourth solution, do the second solution in one for loop, one pass
        Map<Integer, Integer> numsMap = new HashMap<>();
        int remTarget;
        for(int i = 0; i < nums.length; i++) {
            remTarget = target - nums[i];
            if(numsMap.containsKey(remTarget) && numsMap.get(remTarget) != i) {
                return new int[] {i, numsMap.get(remTarget)};
            }

            numsMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution exist!");


        //Third solution, use a HashMap and store all the values in map, then look for the
        //expected value of the values in the map.
        /*Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        int remainingTarget;
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++) {
            remainingTarget = target - nums[i];
            if(numsMap.containsKey(remainingTarget) && numsMap.get(remainingTarget) != i) {
                return new int[] {numsMap.get(nums[i]), numsMap.get(remainingTarget)};
            }
        }

        throw new IllegalArgumentException("No solution exist!");*/

        //Second solution, sort the array and use two indices, sorting is O(n(log(n))), and while
        //loop has O(n) complexity, where n is the length of the nums array
       /* Arrays.sort(nums);

        int head = 0;
        int tail = nums.length - 1;
        int currTotal;
        while(head < tail) {
            currTotal = nums[head] + nums[tail];

            if(currTotal == target) {
                break;
            } else if(currTotal < target) {
                head++;
            } else {
                tail--;
            }
        }

        return new int[]{head, tail};*/

        //First solution that occurs O(n^2) computational complexity, O(1) space complexity
        /*int len = nums.length;
        int num1, num2;

        for(int i = 0; i < len; i++) {
            num1 = nums[i];
            for(int j = i; j < len; j++) {
                if(num1 + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;*/
    }

}
