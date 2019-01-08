/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */

public class LC_541_ReverseStringII {

    /*
    This was a bit hard question for me, handling the edge cases is a bit confusing. At the beginning I wrote a very
    long solution. However, the following is obtained from the discussion which is a very neat solution. The idea is
    that we either use char array of String builder since string is immutable. Than we need to reverse every k element
    for every 2k. So, we can hit the wall at the end, but int end = Math.min(i + k - 1, len - 1); this part of code
    prevents that. It gets the minimum of the length or the added part.
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] cArr = s.toCharArray();

        int i = 0;

        while(i < len) {
            int end = Math.min(i + k - 1, len - 1);  //For the last part
            reverseFirstKCharacters(i, end, cArr);
            i = i + 2 * k;
        }
        return String.valueOf(cArr);
    }

    private void reverseFirstKCharacters(int start, int end, char[] cArr) {
        while(start < end) {
            char tmp = cArr[start];
            cArr[start++] = cArr[end];
            cArr[end--] = tmp;
        }
    }

}
