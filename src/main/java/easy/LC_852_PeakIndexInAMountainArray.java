package easy;/*
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
 */

public class LC_852_PeakIndexInAMountainArray {

    /*
    The time complexity is O(N) and space complexity is O(1). We can do a binary search to decrease time.
    */
    public int peakIndexInMountainArray(int[] A) {  //LinearScan
        int peakIndex = 0;
        int len = A.length;

        for(int i = 0; i < len - 1; i++) {
            if(A[i] > A[i + 1]) {
                peakIndex = i;
                break;
            }
        }
        return peakIndex;
    }

    public int peakIndexInMountainArrayBinarySearchOriginalSolution(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    /*
    The time complexity is O(log(N)) and space complexity is O(1).
    */
    public int peakIndexInMountainArrayBinarySearch(int[] A) {   //BinarySearch
        int low = 1;
        int high = A.length - 2;
        int mid = low + (high - low) / 2;
        int peakIndex = -1;

        while(low < high) {
            if(A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                low = mid;
                mid = low + (high - low) / 2;
            } else if(A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                high = mid + 1;
                mid = low + (high - low) / 2;
            } else {
                peakIndex = mid;
            }
        }

        return peakIndex;
    }
}
