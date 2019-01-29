package easy;/*
X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].
 */

public class LC_788_RotatedDigits {

    /*
    Time complexity is O(NM) where N is the number M is the length of the number in string format. But since it is
    limited to 10000 which is 5, we can say it is O(N).
    Space complexity is O(1)
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(isRotated(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRotated(int i) {
        String s = String.valueOf(i);
        boolean isTrue = false;
        for(char c : s.toCharArray()) {
            if(c == '3' || c == '4' || c == '7') {
                return false;
            } else if (c == '2' || c == '5' || c == '6' || c == '9') {
                isTrue = true;
            }
        }
        return isTrue;
    }

    /*
    Different solution from the discussions
     */
    public int rotatedDigits2(int N) {
        int count = 0;
        for (int i = 1; i <= N; i ++) {
            if (isValid(i)) count ++;
        }
        return count;
    }

    public boolean isValid(int N) {
        /*
         Valid if N contains ATLEAST ONE 2, 5, 6, 9
         AND NO 3, 4 or 7s
         */
        boolean validFound = false;
        while (N > 0) {
            if (N % 10 == 2) validFound = true;
            if (N % 10 == 5) validFound = true;
            if (N % 10 == 6) validFound = true;
            if (N % 10 == 9) validFound = true;
            if (N % 10 == 3) return false;
            if (N % 10 == 4) return false;
            if (N % 10 == 7) return false;
            N = N / 10;
        }
        return validFound;
    }
}
