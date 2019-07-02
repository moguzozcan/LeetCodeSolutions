package easy;

import java.util.*;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class LC_448_FindAllNumbersDissappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);

        boolean[] nums2 = new boolean[nums.length];

        List<Integer> disappearedElements = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            nums2[nums[i] - 1] = true;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums2[i] == false) {
                disappearedElements.add(i + 1);
            }
        }

        return disappearedElements;
    }

    /**
     * The trick is that, loop through the array, for the elements, go to the location whose index is the one minus element,
     * then convert that element in that location to its negative one, if it is positive, meaning if it did not converted
     * before. Then, loop array again and find the ones that are positive, they are the ones that are not in the list,
     * but be careful that the index was one minus, so when finding the number add 1 to the indexes.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersOn(int[] nums) {
        for(int i : nums) {
            if(nums[Math.abs(i) - 1] > 0) {
                nums[Math.abs(i) - 1] = -1 * nums[Math.abs(i) - 1];
            }
        }

        List<Integer> returnList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                returnList.add(i + 1);
            }
        }
        return returnList;
    }
}
