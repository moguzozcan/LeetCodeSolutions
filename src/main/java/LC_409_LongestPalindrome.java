/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

import java.util.HashMap;
import java.util.Map;

public class LC_409_LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c: s.toCharArray()) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        int totalLength = 0;
        boolean isOddOccurred = false;

        for(Map.Entry entry : charCountMap.entrySet()) {
            int val = (Integer) entry.getValue();
            if(val % 2 == 0) {
                totalLength += val;
            } else {
                totalLength += val - 1;
                isOddOccurred = true;
            }
        }

        return isOddOccurred ? totalLength + 1 : totalLength;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int out = 0;
        for (int val: count) {
            out += val / 2 * 2;
            if (out % 2 == 0 && val % 2 == 1)
                out++;
        }
        return out;
    }
}
