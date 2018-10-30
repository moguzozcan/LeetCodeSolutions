/*
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
 */

import java.util.HashMap;
import java.util.Map;

public class LC_389_FindTheDifference {

    private Map<Character, Integer> sMap = new HashMap<>();
    private Map<Character, Integer> tMap = new HashMap<>();

    public char findTheDifference(String s, String t) {

        for(Character c : s.toCharArray()) {
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        for(Character c : t.toCharArray()) {
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) - 1);
                if(sMap.get(c) == -1) {
                    return c;
                }
            } else {
                return c;
            }
        }
        return '-';
    }

    //Other solution
    public char findTheDifference2(String s, String t) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            arr[c - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(arr[i] == 1 || arr[i] == -1) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }

    // adding the ascii values of all the characters in s and t and taking the difference
    public char findTheDifference3(String s, String t) {
        if (s.length()==0 && t.length()==0) return '-';
        int sums =0;
        int sumt =0;
        int i =0;
        int len = s.length();
        for (i =0; i < len;i++){
            sums = sums+s.charAt(i);
            sumt = sumt+t.charAt(i);
        }
        sumt = sumt+t.charAt(i);
        return (char)(sumt-sums);
    }
}