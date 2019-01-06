/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

public class LC_520_DetectCapital {

    /*
    There are three cases and this question is all about handling them with a good fashion. The code first looks at the
    first character. Then if the first character is Upper case there are two options, the remaining will be all upper
    or all lower case. If the capital letter is lower case then the remaining all characters must be all lower case.
    The following code will implement this. If the word contains only one letter, then it returns true, this is an edge
    case.
     */
    public boolean detectCapitalUse(String word) {
        int len = word.length();

        if(len == 1) {
            return true;
        }

        boolean isInitialCapital = Character.isUpperCase(word.charAt(0));

        if(isInitialCapital) {
            boolean isUpperCaseSecondLetter = Character.isUpperCase(word.charAt(1));
            if(isUpperCaseSecondLetter) {
                for(int i = 1; i < len; i++) {
                    if(!Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                for(int i = 1; i < len; i++) {
                    if(Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            for(int i = 1; i < len; i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    /*
    We can also use the following method to decrease the duplicate codes and line count, but when I do this my runtime
    increase to 23ms from 12ms. I think making a method call is
     */
    private boolean isRemainingLowerCase(String word, int len) {
        for(int i = 1; i < len; i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /*
    Very easy solution with regex
     */
    public boolean detectCapitalUseRegex(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
