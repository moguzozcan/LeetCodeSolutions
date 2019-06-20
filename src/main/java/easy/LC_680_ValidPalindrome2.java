package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

public class LC_680_ValidPalindrome2 {

    /**
     * The first idea is brute force solution, where we can try each of the string by discarding one character
     * The complexity will be O(N^2) where N is the length of the string and space complexity will be O(1) we do not use
     * any extra space
     * <p>
     * The second idea is a greedy solution, more intelligent. Since we are allowed at most one character, we can look for
     * the characters one from beginning and one from the end. Then we can compare them, until they are not the same, we
     * move to the middle. When they are not the same, try 2 options: 1 move left pointer to one right and if
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        int count = 0;

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                //Try both by decreasing end and increasing start cases and success if one of them is okey
                return isRemainingPalindrome(s, startIndex + 1, endIndex) || isRemainingPalindrome(s, startIndex, endIndex - 1);
            }
        }
        return true;
    }

    private boolean isRemainingPalindrome(String s, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        LC_680_ValidPalindrome2 lc_680_validPalindrome2 = new LC_680_ValidPalindrome2();
        System.out.println(lc_680_validPalindrome2.validPalindrome(s));
    }
}


/*



public boolean validPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        int count = 0;

        while(startIndex < endIndex) {
            if(s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                //Try both by decreasing end and increasing start cases
                if(s.charAt(startIndex + 1) == s.charAt(endIndex) && count == 0) {
                    startIndex += 2;
                    endIndex--;
                    count++;
                } else if (s.charAt(startIndex) == s.charAt(endIndex - 1) && count == 0) {
                    startIndex++;
                    endIndex -= 2;
                    count++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    /*
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length();
        int count = 0;

        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return isRemainingPalindrome(s, start, end);

            }
        }

        return true;
    }

    private boolean isRemainingPalindrome(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s);
        sb.remove(start);
                ifsb.toString().equals(sb.reverse().toString());

    }*/
/*
        if (s.charAt(startIndex + 1) == s.charAt(endIndex) && count == 0) {
            startIndex += 2;
            endIndex--;
            count++;
        } else if (s.charAt(startIndex) == s.charAt(endIndex - 1) && count == 0) {
            startIndex++;
            endIndex -= 2;
            count++;
        } else {
            return false;
        }
 */
