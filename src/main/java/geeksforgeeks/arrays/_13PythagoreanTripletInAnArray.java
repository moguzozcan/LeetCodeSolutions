package geeksforgeeks.arrays;

import java.util.Arrays;

/*
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Input:
The first line contains T, denoting the number of testcases. Then follows description of testcases. Each case begins
with a single positive integer N denoting the size of array. The second line contains the N space separated positive
integers denoting the elements of array A.

Output:
For each testcase, print "Yes" or  "No" whether it is Pythagorean Triplet or not (without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[i] <= 1000

Example:
Input:
1
5
3 2 4 6 5

Output:
Yes

Explanation:
Testcase 1: a=3, b=4, and c=5 forms a pythagorean triplet, so we print "Yes"
 */
public class _13PythagoreanTripletInAnArray {

    /*
    Time Complexity of the above solution is O(n3).
     */
    public static boolean isTriplet(int arr[]) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                for(int k = j + 1; k < len; k++) {
                    int x = arr[i] * arr[i];
                    int y = arr[j] * arr[j];
                    int z = arr[k] * arr[k];

                    if((x == (y + z)) || (y == (x + z)) || (z == (x + y))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    Method 2 (Use Sorting)
    We can solve this in O(n2) time by sorting the array first.

    1) Do square of every element in input array. This step takes O(n) time.

    2) Sort the squared array in increasing order. This step takes O(nLogn) time.

    3) To find a triplet (a, b, c) such that a2 = b2 + c2, do following.

    Fix ‘a’ as last element of sorted array.
    Now search for pair (b, c) in subarray between first element and ‘a’. A pair (b, c) with given sum can be found in
    O(n) time using meet in middle algorithm discussed in method 1 of this post.
    If no pair found for current ‘a’, then move ‘a’ one position back and repeat step 3.2.
     */
    public static boolean isTripletON2(int arr[]) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        for (int i = len - 1; i > 1 ; i--) {

            int lo = 0;
            int hi = i - 1;

            while(lo < hi) {
                if(arr[lo] + arr[hi] < arr[i]) {
                    lo++;
                } else if (arr[lo] + arr[hi] > arr[i]) {
                    hi--;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int ar[] = {3, 1, 4, 6, 5};
        System.out.println(isTriplet(ar));
        System.out.println(isTripletON2(ar));
    }

}
