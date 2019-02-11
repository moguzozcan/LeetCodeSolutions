package geeksforgeeks.arrays;

/*
Given an array of positive integers. Reverse every sub-array of K group elements.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each
test case consist of two lines of input. The first line of each test case consists of an integer N(size of array) and
an integer K separated by a space. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For test case, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ A[i] ≤ 1018

Example:
Input
1
5 3
1 2 3 4 5

Output
3 2 1 5 4
 */
public class _10ReverseArrayInGroups {

    /*
    Edge case: Last part of the array is less than k, how to solve this? Check if the remaining is less than k,
    If not just reverse the array in place, if yes reverse the remaining part.
    Edge cases: k = 1 return array as it is.
    If k > array size reverse the whole array.
     */
    public static void reverseArray(int arr[], int k) {
        int len = arr.length;
        int[] reversed = new int[len];

        if (k == 1) {
            return;
        }

        int reverseIndex = k;
        for (int i = 0; i < len; i = i + k) {
            if (len - i < k) {
                reverse(arr, i, len - 1);
            } else {
                reverse(arr, i, i + k - 1);
            }
        }
    }

    private static void reverse(int[] arr, int lo, int hi) {
        int tmp = 0;

        while (lo < hi) {
            tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        int n = arr.length;

        reverseArray(arr, k);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    static void reverse2(int arr[], int n, int k) {
        for (int i = 0; i < n; i += k) {
            int left = i;

            // to handle case when k is not multiple
            // of n
            int right = Math.min(i + k - 1, n - 1);
            int temp;

            // reverse the sub-array [left, right]
            while (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left += 1;
                right -= 1;
            }
        }
    }
}
