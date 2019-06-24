package medium;

/*
Difficulty: Medium
Companies: Facebook

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

public class LC_50_PowXN {
    /**
     This is the iterative very basic solution, just need to check minus
     and zero conditions.

     Ranges could be important, maybe big integer? Or long

     */
    public double myPow(double x, int n) {
        double result = 1;
        if(n == 0) {
            return 1.0;
        } else {
            if(n < 0) {
                n = -n;
                x = 1 / x;
            }
            if(n % 2 == 1) {
                result = x;
                n--;
            }
            while(n != 0) {
                result = result * x * x;
                n = n / 2;
            }
        }

        return result;
    }

    /**
     * This is the recursive solution just divides n by 2 when calling the function again
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if(n == Integer.MIN_VALUE && x > 1)
            return 0;
        if(n == 0)
            return 1;
        if(n<0){
            n = -n; //consider the overflow situation
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
