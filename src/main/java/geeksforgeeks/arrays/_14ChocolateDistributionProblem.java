package geeksforgeeks.arrays;

import java.util.Arrays;

/*
Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each
packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and
student having packet with minimum chocolates is minimum.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test
case consists of three lines. The first line of each test case contains an integer N denoting the number of packets.
 Then next line contains N space separated values of the array A denoting the values of each packet. The third line of
 each test case contains an integer m denoting the no of students.

Output:
For each test case in a new line print the minimum difference.

Constraints:
1 <= T <= 100
1 <=N<= 107
1 <= Ai <= 1018
1 <= M <= N

Example:
Input:
2
8
3 4 1 9 56 7 9 12
5
7
7 3 2 4 9 12 56
3

Output:
6
2

Explanation:
Testcase 1: The minimum difference between maximum chocolates and minimum chocolates is 9-3=6
 */
public class _14ChocolateDistributionProblem {

    /*
    An efficient solution is based on the observation that, to minimize difference, we must choose consecutive elements
    from a sorted packets. We first sort the array arr[0..n-1], then find the subarray of size m with minimum difference
     between last and first elements.
     Time Complexity : O(n Log n) as we apply sorting before subarray search.
     */
    public static int minDiff(int arr[], int m) {
        int len = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - m + 1; i++) {
            if (minDiff > arr[i + m - 1] - arr[i]) {
                minDiff = arr[i + m - 1] - arr[i];
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 }; // 10

        int m = 7;  // Number of students

        System.out.println("Minimum difference is " + minDiff(arr, m));

    }
}
