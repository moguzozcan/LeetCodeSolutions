package easy;

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple
copies of the substring together. You may assume the given string consists of lowercase English letters only
and its length will not exceed 10000.

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class LC_459_RepeatedSubstringPattern {

    /*
    The length of the repeating substring must be a divisor of the length of the input string
    Search for all possible divisor of str.length, starting for length/2
    If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
    If the repeated substring is equals to the input str return true
     */
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern3(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i = len / 2; i >= 1; i--) {
            if(len % i == 0) {
                int m = len / i;
                for(int k = 0; k < m; k++) {
                    sb.append(s.substring(0, i));
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
                sb.setLength(0);
            }
        }
        return false;
    }

    /*
    The perfect clever solution for this question is given below.

    Basic idea:

    First char of input string is first char of repeated substring
    Last char of input string is last char of repeated substring
    Let S1 = S + S (where S in input string)
    Remove 1 and last char of S1. Let this be S2
    If S exists in S2 then return true else false
    Let i be index in S2 where S starts then repeated substring length i + 1 and repeated substring S[0: i+1]
     */
    public boolean repeatedSubstringPattern2Line(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    //This solution gives "Memory Limit Exceeded" error
    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();

        if(len == 1) {
            return true;
        } else if (len == 2) {
            return s.charAt(0) == s.charAt(1) ? true : false;
        } else {
            if(len % 2 == 1) {
                return false;
            } else {
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < len / 2; i++) {
                    sb.append(s.charAt(i));
                    if(checkIfRepeatedSubstring(s, sb)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private boolean checkIfRepeatedSubstring(String s, StringBuilder sb) {
        while(s.length() != sb.length()) {
            sb.append(sb.toString());
        }

        return s.equals(sb.toString()) ? true : false;
    }
}
