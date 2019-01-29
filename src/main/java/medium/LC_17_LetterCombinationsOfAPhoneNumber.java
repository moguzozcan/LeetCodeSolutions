package medium;

/*
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

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    /*
    Complexity Analysis

    Time complexity : O(3^N*4^M)where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5,
    6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

    Space complexity : O(3^N * 4^M)since one has to keep 3^N * 4^M solutions.
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }


    /*
    I have written the next method after understanding the solution
     */
    public List<String> letterCombinationsIWrote(String digits) {
        if(digits.length() == 0) {
            return output;
        }

        combination("", digits);
        return output;
    }

    private void combination(String combination, String digits) {
        if(digits.length() == 0) {
            output.add(combination);
            return;
        }

        String digit = digits.substring(0, 1);
        String possibilities = phone.get(digit);

        for(int i = 0; i < possibilities.length(); i++) {
            combination(combination + possibilities.substring(i, i + 1), digits.substring(1));
        }
    }
}
