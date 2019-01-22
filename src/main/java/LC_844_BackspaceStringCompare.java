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

    /*
    Idea is to start from the reverse of the string and count the occurence of the # characters and skip that many
    count after we see a real character. Then compare the current characters. If they are different then return false,
    Also compare the remaining length of the strings if they are not equal to or bigger than 0 then return false, this
    compares if we are comparing the current character with non existing character.
     */
    public boolean backspaceCompareO1Space(String S, String T) {
        int lenS = S.length() - 1;
        int lenT = T.length() - 1;

        int skipCountS = 0;
        int skipCountT = 0;

        while(lenS >= 0 || lenT >= 0) {
            while(lenS >= 0) {
                if(S.charAt(lenS) == '#') {
                    skipCountS++;
                    lenS--;
                } else if(skipCountS > 0) {
                    skipCountS--;
                    lenS--;
                } else {
                    break;
                }
            }

            while(lenT >= 0) {
                if(T.charAt(lenT) == '#') {
                    skipCountT++;
                    lenT--;
                } else if(skipCountT > 0) {
                    skipCountT--;
                    lenT--;
                } else {
                    break;
                }
            }

            if(lenS >= 0 && lenT >= 0 && S.charAt(lenS) != T.charAt(lenT)) {
                return false;
            }

            if ((lenS >= 0) != (lenT >= 0))
                return false;

            lenS--;
            lenT--;
        }
        return true;
    }
}
