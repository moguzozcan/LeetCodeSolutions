package medium;

import java.util.Arrays;

/*
Given an unsorted array nums, reorder it in-place such that
nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class LC_280_WiggleSort {

    /**
     * The first observation is that the numbers in the odd positions are peak
     *
     * First solution can be, sort the array and then have two pointers
     * one at the beginning and one at the mid. Then create a new array and fill the
     * newly created array. Filling the first from the middle then next from the
     * beginning and continue like this.
     * @param arr
     */
    public static int[] wiggleSort(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;

        int[] wiggleSorted = new int[len];

        //notice odd/even of array todo
        int mid = len / 2;
        if(len % 2 == 1) {
             mid++;
        }

        int start = 0;
        int index = 0;
        while(mid < len) {
            wiggleSorted[index++] = arr[start];
            start++;
            wiggleSorted[index++] = arr[mid];
            mid++;
        }

        return wiggleSorted;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] wiggleSorted = LC_280_WiggleSort.wiggleSort(nums);
        for(int i : wiggleSorted)
            System.out.print(i);
    }
}
