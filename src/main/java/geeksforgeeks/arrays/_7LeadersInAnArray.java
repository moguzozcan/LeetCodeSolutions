package geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the
rightmost element is always a leader.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print all the leaders.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Ai <= 1018

Example:
Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3

Explanation:
Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right
side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.
 */
public class _7LeadersInAnArray {

    /*
    Method 1 (Simple)
    Use two loops. The outer loop runs from 0 to size – 1 and one by one picks all elements from left to right. The inner
    loop compares the picked element to all the elements to its right side. If the picked element is greater than all the
    elements to its right side, then the picked element is the leader.

    Method 2 (Scan from right)
    Scan all the elements from right to left in array and keep track of maximum till now. When maximum changes it’s value, print it.
     */
    public static void leadersMethod1(int[] arr) {  //Complexity is O(N^2) Space complexity is O(N)
        int len = arr.length;
        boolean isLeader = true;
        List<Integer> leadersList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                }
            }
            if(isLeader)  // j == size also works
                leadersList.add(arr[i]);
            isLeader = true;
        }

        System.out.println(leadersList);
    }

    /*
    Time complexity of this method is O(N) and space complexity is also O(N) where N is the length of the array
     */
    public static void leadersMethod2(int[] arr) {
        int len = arr.length;
        List<Integer> leadersList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--) {
            if (max < arr[i]) {
                leadersList.add(arr[i]);
                max = arr[i];
            }
        }
        System.out.println(leadersList);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        leadersMethod1(arr);
        leadersMethod2(arr);
    }
}
