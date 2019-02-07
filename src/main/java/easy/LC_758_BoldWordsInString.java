package easy;/*
Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> 
and </b> tags become bold.
The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning 
"a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:

words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.
 */

public class LC_758_BoldWordsInString {

    /*
    Create an array to store if the characters at locations will be bolded or not. Loop through the string, and check
    all the words in array, check if the string starts with any of that words, with offset as i.
    Then store the max end index. For each i, make it true if end index is bigger than i. Then create a stringbuilder
    loop through the string, and fill string builder until see shouldBold[i] becomes true. After it becomes true,
    find how many of them are in combined. Then add the <b> and </b> to before and after the string.subtring(i,j)
    into the string builder.
     */
    public String boldWords(String[] words, String S) {
        boolean[] shouldBold = new boolean[S.length()];
        for (int i = 0, end = 0; i < S.length(); i++) {
            for (String word : words) {
                if (S.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            shouldBold[i] = end > i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!shouldBold[i]) {
                stringBuilder.append(S.charAt(i));
                continue;
            }
            int j = i;
            while (j < S.length() && shouldBold[j]) {
                j++;
            }
            stringBuilder.append("<b>" + S.substring(i, j) + "</b>");
            i = j - 1;
        }
        return stringBuilder.toString();
    }
}
