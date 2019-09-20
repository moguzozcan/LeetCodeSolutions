package amazonamcat;

import java.math.BigInteger;

/*
Find number of 1s after multiplying integers
 */
public class AmazonErgazizInt {

    public int solution(int A, int B) {
        BigInteger multiplied = multiply(A, B);

        return count1s(multiplied);

    }

    private BigInteger multiply(int A, int B) {
        BigInteger int1 = new BigInteger(Integer.toString(A));
        BigInteger int2 = new BigInteger(Integer.toString(B));
        BigInteger result =  int1.multiply(int2);

        return result;
    }



    public int count1s(BigInteger n) {
        // base case
        if (n.intValue() == 0) {
            return 0;
        } else {
            // if last bit set add 1 else add 0
            return (n.and(new BigInteger(Integer.toString(1))).intValue() + count1s(n.shiftRight(1)));
        }
    }
}
