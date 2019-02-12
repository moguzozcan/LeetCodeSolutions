package geeksforgeeks.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array and a number k where k is smaller than size of array, the task is to find the k’th smallest element in
the given array. It is given that all array elements are distinct.

Input:

First Line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case
consists of three lines. First line of each test case contains an integer N denoting size of the array. Second line
contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:

Corresponding to each test case, print the desired output in a new line.

Constraints:

1<=T<=200
1<=N<=1000
K

Expected Time Complexity: O(n)

Example:

INPUT
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:

7
15
 */
public class _11KthSmallestElement {

    /*
    The basic idea is sort the array and then get the kth - 1 of it.
     */
    public static int kthSmallest(Integer[] arr, int k) {
        // Sort the given array
        Arrays.sort(arr);

        // Return k'th element in the sorted array
        return arr[k - 1];
    }

    /*
    Worst case O(N) is required, so a min heap has to be used for this. Then we can pop k times from the heap and
    get the kth min value.
     */
    public static int kthSmallestHeap(Integer[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : arr) {
            heap.add(i);
        }

        for(int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    // driver program
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 19};
        int k = 2;
        System.out.println("K'th smallest element is " + kthSmallest(arr, k));

        System.out.println("K'th smallest element is " + kthSmallestHeap(arr, k));

    }

}
