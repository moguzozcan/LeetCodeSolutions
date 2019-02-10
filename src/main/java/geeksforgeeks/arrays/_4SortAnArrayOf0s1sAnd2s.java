package geeksforgeeks.arrays;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases
contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of
xthe array A separated by spaces.

Output:
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 10 to 6
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */
public class _4SortAnArrayOf0s1sAnd2s {

    /*
    This question is similar to 3 color version of the dutch national flag problem by Djisktra. Idea is divide the
    array into 4 portions, the first portion stores 0s, second portion stores 1s, third is used for unknown and fourth
    portion stores 2s. We need lo, mid and high variables to store the indexes of the portions. lo will start from 0, hi
    is the length of the array minus one and mid is also start from 0.

    The time complexity of the solution is O(N) since it finishes in one for loop. And space complexity is O(1), we
    do not use any extra space.
     */
    public static void sort012(int[] arr) {
        int len = arr.length;
        int lo = 0;
        int mid = 0;
        int hi = len - 1;
        int tmp = 0;

        while (mid <= hi) {
            switch (arr[mid]) {
                case 0:
                    tmp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = tmp;
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    tmp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = tmp;
                    hi--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }

    static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
