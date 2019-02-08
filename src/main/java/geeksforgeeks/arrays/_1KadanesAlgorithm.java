package geeksforgeeks.arrays;

/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array. The second line contains N
space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 6 of elements (1, 2, 3) which is a contiguous subarray.
 */

public class _1KadanesAlgorithm {

    /*
    The idea of the Kadane's algorithm is to look for positive portions of the subarrays and store the maximum among
    them. Two variables is used for these events.
     */
    /*
    The question comes to mind is what if all the elements are negative, but kadanes algorithm requires at least one
    positive element in the array.
    According to Wikipedia, Kadane's Algorithm requires at least one positive number, so your all negative array is invalid input.
    https://stackoverflow.com/questions/9942228/kadane-algorithm-negative-numbers

    But for this to work for negative numbers also, store the max element and if max_so_far is 0, return that number,
    very clever!
     */
    public int maxSubArraySum(int[] a) {
        int max_ending_here = 0;
        int max_so_far = 0;  //Only works for at least one non-negative number
        int max_element = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            max_ending_here += a[i];
            if(max_ending_here < 0) {
                max_ending_here = 0;
            }

            if(max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }

            if (max_element < a[i]) {
                max_element = a[i];
            }
        }

        return max_so_far == 0 ? max_element : max_so_far;
    }
}
