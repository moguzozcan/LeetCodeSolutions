package geeksforgeeks.arrays;

/*
Given an array A of N non-negative integers representing height of blocks at index i as Ai where the width of each block
is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
Each test case contains an integer N followed by N numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 107

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped
is 10 units.
 */
public class _12TrappingRainWater {

    /*
    Brute Force:
    The first idea is loop through all the elements and then find the left and right maximum height. Then the current
    point can store amount of water which is, min of the two max heights minus the current location.
    Time Complexity: O(N^2) Space Complexity: O(1)
     */
    public static int findWater(int arr[]) {
        int len = arr.length;
        int total = 0;

        for(int i = 1; i < len - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for(int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            for(int j = i; j < len; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            total += Math.min(leftMax, rightMax) - arr[i];
        }
        return total;
    }

    /*
    Use the space for time gain. Store the left and right max heights for each location, and use them for the calculation.
    Time Complexity: O(N) - Space complexity: O(N)
     */
    public static int findWaterDP(int arr[]) {
        int len = arr.length;

        int left[] = new int[len];
        int right[] = new int[len];

        left[0] = arr[0];
        right[len - 1] = arr[len - 1];

        for(int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        for(int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int total = 0;
        for(int i = 0; i < len; i++) {
            total += Math.min(left[i], right[i]) - arr[i];
        }

        return total;
    }

    /*
    Instead of storing two arrays, we can just store two variables, which holds the left and right max elements. We also
    need to store lo and hi for begin and end indexes of the arrays. If the element at lo is smaller than element at
    hi, then we just look at the element left_max. If left_max is smaller than the element, we update the left_max
    as the current element.
    we will just maintain two variables to store the maximum till that point. Since water trapped at any element =
    min( max_left, max_right) – arr[i] we will calculate water trapped on smaller element out of A[lo] and A[hi] first
    and move the pointers till lo doesn’t cross hi.
     */
    public static int findWaterSpaceOptimized(int arr[]) {
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;

        int lo = 0;
        int hi = arr.length - 1;

        int res = 0;

        while(lo < hi) {
            if(arr[lo] < arr[hi]) {
                if(arr[lo] > left_max) {
                    left_max = arr[lo];
                } else {
                    res += left_max - arr[lo];
                }
                lo++;
            } else {
                if(arr[hi] > right_max) {
                    right_max = arr[hi];
                } else {
                    res += right_max - arr[hi];
                }
                hi--;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr2[] = {3, 0, 0, 2, 0, 4};

        System.out.println(findWater(arr));
        System.out.println(findWater(arr2));

        System.out.println(findWaterDP(arr));
        System.out.println(findWaterDP(arr2));

        System.out.println(findWaterSpaceOptimized(arr));
        System.out.println(findWaterSpaceOptimized(arr2));

    }

}
