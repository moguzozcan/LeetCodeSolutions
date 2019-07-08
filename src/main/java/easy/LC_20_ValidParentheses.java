package easy;
/*
Difficulty: Easy
Companies: Facebook

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_20_ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        LC_20_ValidParentheses LC20ValidParentheses = new LC_20_ValidParentheses();

        LC20ValidParentheses.isValid2(s);
    }

    public boolean isValid2(String s) {
        Deque<Character> parenthesisStack = new ArrayDeque<>();

        char[] parenthesisArr = s.toCharArray();

        for (char c : parenthesisArr) {
            if (c == '(' || c == '{' || c == '[') {
                parenthesisStack.push(c);
            } else if (c == ')') {
                if (parenthesisStack.peekFirst() == null) {
                    return false;
                }
                if (parenthesisStack.peekFirst() == '(') {
                    parenthesisStack.removeFirst();
                }
            } else if (c == '}') {
                if (parenthesisStack.peekFirst() == null) {
                    return false;
                }
                if (parenthesisStack.peekFirst() == '{') {
                    parenthesisStack.removeFirst();
                }
            } else if (c == ']') {
                if (parenthesisStack.peekFirst() == null) {
                    return false;
                }
                if (parenthesisStack.peekFirst() == '[') {
                    parenthesisStack.removeFirst();
                }
            } else {
                return false;
            }
        }
        return parenthesisStack.size() == 0;
    }


    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if (s.length() < 2) {
            return false;
        }
        for (char c : s.toCharArray()) {
            System.out.println(c);

            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            } else if (c == ')') {
                System.out.println(stack.peekFirst());
                if (stack.peekFirst() != '(' || stack.peekFirst() == null) {
                    return false;
                }
                stack.removeFirst();
            } else if (c == ']') {
                if (stack.peekFirst() != '[' || stack.peekFirst() == null) {
                    return false;
                }
                stack.removeFirst();
            } else {
                if (stack.peekFirst() != '{' || stack.peekFirst() == null) {
                    return false;
                }
                stack.removeFirst();
            }
        }
        return true;
    }
}
