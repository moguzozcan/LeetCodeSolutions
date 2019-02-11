package geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is
N(the size of array). The second line of each test case contains array elements.

Output:
For each test case print the required answer in new line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106

Example:
Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100) has
maximum sum,i.e., 106.
 */
public class _9MaximumOfAllSubarraysOfSizeK {

    public static List<Integer> findMax(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        int len = arr.length;

        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (currMax < arr[i]) {
                currMax = arr[i];
            }
        }

        list.add(currMax);

        for (int i = 1; i < len - k + 1; i++) {
            if (currMax < arr[i + k - 1]) {
                list.add(arr[i + k - 1]);
                currMax = arr[i + k - 1];
            } else {
                list.add(currMax);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        System.out.println(findMax(arr, k));
    }
}
