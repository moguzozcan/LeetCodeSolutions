/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class LC_415_AddStrings {

    /*
    The idea is start from the end of the string and implement the normal adding operation. Add the two characters,
    carry the left one and use string builder for efficiency. At the end reverse the string builder since we add
    sb from the beginning. At the end check if the carry is not equal to 0, if not we need to add that carry too.
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        int carry = 0;

        int num1Current = 0, num2Current = 0;

        StringBuilder sb = new StringBuilder();

        while(len1 >= 0 || len2 >= 0) {
            if(len1 >= 0) {
                num1Current = num1.charAt(len1) - '0';
                len1--;
            }

            if(len2 >= 0) {
                num2Current = num2.charAt(len2) - '0';
                len2--;
            }

            carry = num1Current + num2Current + carry;

            sb.append(carry % 10);
            carry = carry / 10;
            num1Current = 0;
            num2Current = 0;
        }

        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
