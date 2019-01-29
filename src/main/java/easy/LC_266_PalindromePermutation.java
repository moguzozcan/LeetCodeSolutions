package easy;/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
 */

import java.util.HashMap;
import java.util.Map;

/*
The idea is simple here, if for any string to be palindromic, the occurrences of the each character must be even, or
at most one of the occurrence can be odd. There is a further check that if the length of the string is even, all characters
must have even occurrences. If length is odd, then one character must have odd number of occurrence.

The time complexity is O(n) and space complexity is also O(n). We can reduce space complexity to O(1) by using a fixed
sized array. The size of the array must be 128 because the ASCII codes of the characters ranges between 0-127.
 */

public class LC_266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {

        //An array can be used here to reduce space complexity size
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for(Character c : s.toCharArray()) {
            if(characterCountMap.containsKey(c)) {
                characterCountMap.put(c, characterCountMap.get(c) + 1);
            } else {
                characterCountMap.put(c, 1);
            }
        }

        int oddOccurrenceCharacterCount = 0;

        for(Map.Entry entry : characterCountMap.entrySet()) {
            if((Integer) entry.getValue() % 2 == 1) {
                oddOccurrenceCharacterCount++;
                if(oddOccurrenceCharacterCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
