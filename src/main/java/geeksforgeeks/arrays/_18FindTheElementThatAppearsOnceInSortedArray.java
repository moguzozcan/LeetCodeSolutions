package geeksforgeeks.arrays;

/*
Given a sorted array A, size N, of integers; every element appears twice except for one. Find that element in linear
time complexity and without using extra memory.

Input:
The first line of input consists of T, the number of the test cases. T testcases follow. Each testcase contains two lines of input.
The first line of each test case contains the size of the array, and the second line has the elements of the array.

Output:
For each testcase, in a new line, print the number that appears only once in the array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 1017

Example:
Input:
1
11
1 1 2 2 3 3 4 50 50 65 65
Output:
4
 */
public class _18FindTheElementThatAppearsOnceInSortedArray {

    /*
    The first basic idea is since array is sorted, we can search the array from left to right. If the current and next
    element are not equal, return the current element. Be careful about the edge cases which is, if the element is at
    the last location.
    Time complexity: O(N)
    Space complexity: O(1)
     */
    public static int onceOccuringElement(int arr[]) {
        int len = arr.length;
        int i = 0;
        for (; i < len - 1; i = i + 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        if (i == len - 1) {
            return arr[len - 1];
        }
        return -1;
    }

    /*
    A better solution is to use the binary search since the array is sorted. If the element at the mid of the array is
    at the even location, then look for the next element. If they are equal, the order is not broken yet and the once
    occurring element is at a location larger than the mid element. If they are not equal, the element is at the location
    smaller than mid. Same is valid if the mid element is odd. Then compare the mid with a previous element.
     */
    public static int search(int arr[]) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = lo + (hi - lo) / 2;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if(mid % 2 == 0) {
                if(arr[mid] == arr[mid + 1]) {
                    lo = mid + 2;
                } else {
                    hi = mid;
                }
            } else {
                if(arr[mid - 1] == arr[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 4, 5, 5, 6, 6};
        System.out.println(onceOccuringElement(arr));
        System.out.println(search(arr));
    }
}
