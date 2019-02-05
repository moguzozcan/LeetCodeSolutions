package easy;

/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no
such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */

public class LC_686_RepeatedStringMatch {

    /*
    The idea is to keep adding A into StringBuilder until the length of sb is bigger than B, then check if sb contains
    B, if not add one more A into sb, if sb contains B, return count + 1, else return -1;
     */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);

        int count = 1;

        while(sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if(sb.toString().contains(B)) {
            return count;
        } else if(sb.append(A).toString().contains(B)) {
            return count + 1;
        } else {
            return -1;
        }
    }

}
