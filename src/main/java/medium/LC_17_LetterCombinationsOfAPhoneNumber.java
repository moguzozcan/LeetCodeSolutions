package medium;

/*
Difficulty: Medium
Companies: Facebook

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_17_LetterCombinationsOfAPhoneNumber {

    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     Complexity Analysis

     Time complexity : O(3^N*4^M)where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5,
     6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

     Space complexity : O(3^N * 4^M)since one has to keep 3^N * 4^M solutions.
     */
    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0) {
            return combinations;
        }

        findCombinations(combinations, digits, 0, "");

        return combinations;
    }

    private void findCombinations(List<String> combinations, String digits, int index, String str) {
        if(index == digits.length()) {
            combinations.add(str);
            return;
        }

        String letters = phone.get(digits.charAt(index));
        for(char letter : letters.toCharArray()) {
            findCombinations(combinations, digits, index + 1, str + letter);
        }
    }

}
