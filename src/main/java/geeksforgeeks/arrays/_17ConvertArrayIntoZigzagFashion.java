package geeksforgeeks.arrays;

import java.util.Arrays;

/*
Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array
should be in form a < b > c < d > e < f. The relative order of elements is same in the output i.e you have to iterate on
the original array only.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase
contains two lines of input. The first line contains a single integer N denoting the size of array.
The second line contains N space-separated integers denoting the elements of the array.

Output:
For each testcase, print the array in Zig-Zag fashion.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= Ai <= 10000

Example:
Input:
2
7
4 3 7 8 6 2 1
4
1 4 3 2
Output:
3 7 4 8 2 6 1
1 4 2 3
 */
public class _17ConvertArrayIntoZigzagFashion {

    /*
    This is the easy solution, sort the array and then swap all the pair elements starting from index 1.
    Time complexity O(nlogn) because of the sorting. Space complexity is O(1)
     */
    public static void convertToZigzag(int arr[]) {
        Arrays.sort(arr);

        int len = arr.length;
        int tmp;
        for(int i = 1; i < len - 1; i = i + 2) {
            tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
    }

    /*
    This is a more efficient solution, uses one pass of the bubble sort algorithm and swap the elements accordingly.
    Time complexity is O(N), space complexity is O(1)
     */
    public static void zigzag(int[] arr) {

        boolean isSmallerRelation = true;

        int len = arr.length;

        for(int i = 0; i < len - 1; i++) {
            if(isSmallerRelation) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
                isSmallerRelation = !isSmallerRelation;
            } else {
                if(arr[i] < arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
                isSmallerRelation = !isSmallerRelation;
            }
        }

    }

    static int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};
    static int arr2[] = new int[]{4, 3, 7, 8, 6, 2, 1};

    public static void main(String[] args)
    {
        convertToZigzag(arr);
        System.out.println(Arrays.toString(arr));

        zigzag(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
