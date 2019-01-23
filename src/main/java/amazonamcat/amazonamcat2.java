package amazonamcat;

/*
The greatest common divisor (GCD), also called highest common factor (HCF) of N numbers is the largest positive integer
that divides all numbers without giving a remainder.

Write an algorithm to determine the GCD of N positive integers.

Input
The input to the function/method consists of two arguments -
num, an integer representing the number of positive integers (N).
arr, a list of positive integers. Output Return an integer representing the GCD of the given positive integers.

Example
Input:
num = 5
arr = [2, 4, 6, 8, 10]

Output:
2

Explanation:
The largest positive integer that divides all the positive integers 2, 4, 6, 8, 10 without a remainder is 2.
So, the output is 2.
 */


public class amazonamcat2 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = gcd(arr[i], result);
        }
        return result;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    // METHOD SIGNATURE ENDS
}
