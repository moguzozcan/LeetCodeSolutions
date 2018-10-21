/**
 * Given an integer, write a function to determine if it is a power of two.

 Example 1:

 Input: 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: 218
 Output: false
 */
public class LC_231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int remaining = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    /*
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
     */
}
