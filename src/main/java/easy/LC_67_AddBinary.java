package easy;

/*
Difficulty: Easy
Companies: Facebook

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class LC_67_AddBinary {

    /**
     * The idea is to convert all characters to integer using Character.getNumericValue() method, then starting
     * from the end of two strings, add the numeric values in base 2. Watch the transfer values. Then check for the
     * longer string value. At the end, don't forget to add the transfer value to the beginning if it's value is 1.
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int lenA = a.length();
        int lenB = b.length();

        int transfer = 0;
        while(lenA > 0 && lenB > 0) {
            int res = (Character.getNumericValue(a.charAt(lenA - 1)) + Character.getNumericValue(b.charAt(lenB - 1)) + transfer) % 2;
            transfer = (Character.getNumericValue(a.charAt(lenA - 1)) + Character.getNumericValue(b.charAt(lenB - 1))  + transfer) / 2;
            sb.append(res);
            lenA--;
            lenB--;
        }

        while(lenA > 0) {
            int res = (Character.getNumericValue(a.charAt(lenA - 1)) + transfer) % 2;
            transfer = (Character.getNumericValue(a.charAt(lenA - 1)) + transfer) / 2;
            sb.append(res);
            lenA--;
        }

        while(lenB > 0) {
            int res = (Character.getNumericValue(b.charAt(lenB - 1)) + transfer) % 2;
            transfer = (Character.getNumericValue(b.charAt(lenB - 1)) + transfer) / 2;
            sb.append(res);
            lenB--;
        }

        if(transfer == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
