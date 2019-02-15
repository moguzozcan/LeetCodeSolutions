package geeksforgeeks.arrays;

/*
Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and
all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second
line contains N space separated array elements.

Output:
For each test case, in a new line print the required element. If no such element present in array then print -1.

Constraints:
1 <= T <= 100
3 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
3
4
4 2 5 7
3
11 9 12
6
4 3 2 7 8 9

Output:
5
-1
7
Explanation:
Testcase 1 : Elements on left of 5 are smaller than 5 and on right of it are greater than 5.
 */
public class _16ElementWithLeftSideSmallerAndRightSideGreater {

    /*
    Time Complexity: O(n)
    Auxiliary Space: O(n)
    Further Optimization to above approach is to use only one extra array and traverse input array only twice. First
    traversal is same as above and fills leftMax[]. Next traversal traverses from right and keeps track of minimum.
    The second traversal also finds the required element.
     */
    public static int findElement(int arr[]) {
        int index = -1;
        int len = arr.length;

        int leftMax[] = new int[len];
        int rightMin[] = new int[len];
        leftMax[0] = arr[0];
        rightMin[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
                return i;
            }
        }
        /*
        int rightMin2 = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            // Check if we found a required element
            if (leftMax[i] < arr[i] && rightMin2 > arr[i])
                return i;

            // Update right minimum
            rightMin2 = Math.min(rightMin2, arr[i]);
        }*/

        return index;
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};

        System.out.println(findElement(arr));
    }
}
