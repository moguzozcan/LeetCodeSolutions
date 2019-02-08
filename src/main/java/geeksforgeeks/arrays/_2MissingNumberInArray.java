package geeksforgeeks.arrays;

/*
Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number
is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case first line contains
N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 */

import java.util.Arrays;

public class _2MissingNumberInArray {

    /*
    This complexity is O(nlog(n)) because of the Arrays.sort(). It uses dual pivot quick sort algorithm. The space
    complexity is O(1). This is the easiest solution.
     */
    public static int missingNumnber(int[] arr) {
        int len = arr.length;
        int missingNumber = 0;

        Arrays.sort(arr);

        for(int i = 1; i <= len; i++) {
            if(arr[i - 1] != i) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }

    /*
    The idea in this method is use an array to mark the existing elements by using index of the arrays, then loop
    through the new array and if an element is 0, return one plus the index of that element.
    Time and space complexity is O(N)
     */
    public static int missingNumnberO1(int[] arr) {
        int len = arr.length;
        int missingNumber = 0;
        int[] numbers = new int[len + 1];

        for(int i : arr) {
            numbers[i - 1] = 1;
        }

        for(int i = 0; i <= len; i++) {
            if(numbers[i] == 0) {
                missingNumber = i + 1;
                break;
            }
        }
        return missingNumber;
    }

    /*
    Idea is clever. Find the total sum and subtract the element one by one and the remaining is the missing element.
     */
    public static int missingNumnberSum(int[] arr) {
        int len = arr.length;

        int sum = (len + 1) * (len + 2) / 2;
        int total = 0;

        for(int i : arr) {
            total += i;
        }

        return sum - total;
    }

    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int miss = missingNumnberSum(a);
        System.out.println(miss);

        int miss2 = missingNumnberO1(a);
        System.out.println(miss2);

        int miss3 = missingNumnber(a);
        System.out.println(miss3);
    }
}
