package geeksforgeeks.string;

/*
Given a String of length S, reverse the whole string without reversing the individual
words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each
case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr

 */
public class _1ReverseWordsInAGivenString {
    public static String reverseString(String str) {
        String[] tokens = str.split("\\.");
        StringBuilder sb = new StringBuilder();

        for(int i = tokens.length - 1; i >= 0; i--){
            sb.append(tokens[i] + '.');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";

        System.out.println(_1ReverseWordsInAGivenString.reverseString(str));
    }
}
