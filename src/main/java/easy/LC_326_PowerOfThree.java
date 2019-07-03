package easy;

/*
Difficulty: Easy
Companies: Google

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
 */

public class LC_326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }

        int rem;
        while(n != 1) {
            rem = n % 3;
            if(rem != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }
}
