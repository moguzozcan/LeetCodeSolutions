package easy;

/*
Difficulty: Easy
Companies: Facebook

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
 */

public class LC_824_GoatLatin {

    /**
     * Questions words are separated by spaces, no other delimeter,
     * String can be null or empty string? what happens then return null or the string itself
     * The time complexity of this solution is O(N^2) where N is the length of the string and first N is the length
     * of the given string,
     * The space complexity is also O(N^2) since we create extra a characters and at the end we might end up with the
     * N a's
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {

        String[] tokens = S.split(" ");
        int size = tokens.length;

        StringBuilder resultStr = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(tokens[i - 1]);
            char firstChar = sb.charAt(0);
            if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') {
                sb.append("ma");
                appendAs(sb, i);
                resultStr.append(sb.toString() + " ");
            } else {
                sb.deleteCharAt(0);
                sb.append(firstChar);
                sb.append("ma");
                appendAs(sb, i);
                resultStr.append(sb.toString() + " ");
            }
            sb.setLength(0);
        }
        resultStr.deleteCharAt(resultStr.length() - 1);
        return resultStr.toString();
    }

    private void appendAs(StringBuilder sb, int i) {
        for (int j = 0; j < i; j++) {
            sb.append("a");
        }
    }
}
