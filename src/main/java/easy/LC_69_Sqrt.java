package easy;

/*
Difficulty: Easy
Companies: Facebook

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.

 */
public class LC_69_Sqrt {

    /**
     * Look for the critical point: i * i <= x && (i+1)(i+1) > x
     * A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.
     * Solution1 - Binary Search Solution: Time complexity = O(lg(x)) = O(32)=O(1)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }
}