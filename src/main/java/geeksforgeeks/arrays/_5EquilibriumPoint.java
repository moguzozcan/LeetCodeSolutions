package geeksforgeeks.arrays;

/*
Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array.
Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line
of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

Output:
For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai <= 108

Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3

Explanation:
Testcase 1: Since its the only element hence its the only equilibrium point.
Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).
 */
public class _5EquilibriumPoint {

    /*
    The idea is to first calculate the sum, then one by one calculate the sum from left and discard the current sum from
    total sum and also subtract the element right after the current position from the total sum. If the current sum
    equal to that number return i + 1 which is the equilibrium point.
     */
    public static int equilibrium(int arr[]) {
        int len = arr.length;
        int total = 0;

        for(int i : arr) {
            total += i;
        }

        int currentSum = 0;
        for(int i = 0; i < len - 1; i++) {
            currentSum += arr[i];
            if(currentSum == total - currentSum - arr[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = { 1, 4, 2, 5 };
        System.out.println(equilibrium(arr));

        int arr2[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(equilibrium(arr2));
    }
}
