/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_844_BackspaceStringCompare {


    /*
    This is the first solution that comes to my mind. This question is screaming that I need to use stack :)
    But the edge cases are, if there is a backspace when there is no element to delete, then to avoid getting an
    exception, I need to check if the stack sizes are the same. Also, for two Strings to be equal their sizes has to
    be same, I need to check that first. The time complexity is O(N) since I loop through the Strings and the space
    complexity is O(N) again.

    This solution works, but it also asks me that, If I can solve it in O(N) time and O(1) space, which means without
    using an extra space?
     */
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();

        for(char c : S.toCharArray()) {
            if(c == '#') {
                if(stackS.size() != 0) {
                    stackS.removeFirst();
                }
            } else {
                stackS.addFirst(c);
            }
        }

        for(char c : T.toCharArray()) {
            if(c == '#') {
                if(stackT.size() != 0) {
                    stackT.removeFirst();
                }
            } else {
                stackT.addFirst(c);
            }
        }

        if(stackS.size() != stackT.size()) {
            return false;
        }

        while(stackS.size() != 0) {
            if(stackS.removeFirst() != stackT.removeFirst()) {
                return false;
            }
        }
        return true;
    }
}
