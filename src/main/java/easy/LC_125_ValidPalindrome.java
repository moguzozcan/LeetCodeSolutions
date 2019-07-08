package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class LC_125_ValidPalindrome {

    /**
     * Use string builder and regex to consider only alphanumeric characters
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.replaceAll("[^A-Za-z0-9]", ""));

        String actual = sb.toString();
        String reverse = sb.reverse().toString();

        return actual.equalsIgnoreCase(reverse);
    }

    /**
     * Another solution using two pointers and Character.isLetterOrDigit method
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
