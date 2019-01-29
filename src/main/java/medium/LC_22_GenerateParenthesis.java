package medium;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.ArrayList;
import java.util.List;

public class LC_22_GenerateParenthesis {

    /*
    Idea is to use the recursion, backtracking, to generate all the possible combinations. The end case is, if the
    length of the current generated string is equal to the two times the input n. If not, we should keep track of the
    open and close parenthesis. The number of open should be smaller than the n input, and the current close should be
    smaller than the number of open.

    The time complexity is seem like 4 to n divided by square root n. The n-th catalan number.
     */
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        generateParenthesis(n, "", list, 0, 0);
        return list;

    }

    private void generateParenthesis(int n, String combination, List<String> list, int numberOfOpen, int numberOfClose) {
        if(combination.length() == n * 2) {
            list.add(combination);
            return;
        }

        if (numberOfOpen < n)
            generateParenthesis(n, combination + "(", list, numberOfOpen+1, numberOfClose);

        if (numberOfClose < numberOfOpen)
            generateParenthesis(n, combination + ")", list, numberOfOpen, numberOfClose+1);
    }
}
