package medium;

/*
Difficulty: Medium
Companies: Amazon

Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.


Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"


Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
*/

public class LC_984_StringWithoutAAAorBBB {

    /**
     * The idea is very simple. While there are more elements to add
     * check the last two character of the string if it is aa or bb the opposite has to be
     * concated to the end. If not we need to check whether A or B is the bigger one, then
     * according to that result we should add a or b and decrease the A or B.
     * @param A
     * @param B
     * @return
     */
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A + B > 0) {
            String s = sb.toString();
            if (s.endsWith("aa")) {
                sb.append("b");
                --B;
            } else if (s.endsWith("bb")) {
                sb.append("a");
                --A;
            } else if (A > B) {
                sb.append("a");
                --A;
            } else {
                sb.append("b");
                --B;
            }
        }
        return sb.toString();
    }
}
