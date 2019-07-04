package easy;

/*
Difficulty: Easy
Companies: Google

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each
element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class LC_66_PlusOne {

    /**
     * The idea is if not all of the numbers are 9, then we can work with the given array, if not, then we need a new
     * array with length 1 plus the current array length and it will be 1 with remaining all zeros.
     * In the for loop we check if the current digit is smaller than 9, then we can return the array itself. If we
     * get out of the for loop, then we have that case and we need a new array.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
