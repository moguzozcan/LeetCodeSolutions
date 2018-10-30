/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
 */

public class LC_408_ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        int lenWord = word.length();
        int lenAbbr = abbr.length();
        int abbrCount = 0;

        for(int i = 0; i < lenWord; i++) {
            if(word.charAt(i) == abbr.charAt(abbrCount)) {
                abbrCount++;
            } else {
                if(isDigit(abbr.charAt(abbrCount))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(abbr.charAt(abbrCount));
                    abbrCount++;

                    while (isDigit(abbr.charAt(abbrCount))) {
                        sb.append(abbr.charAt(abbrCount));
                        abbrCount++;
                    }
                    i = i + Integer.valueOf(sb.toString()) - 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' ||
                c == '8' || c == '9';
    }


    //Solution from internet  http://massivealgorithms.blogspot.com/2016/10/leetcode-408-valid-word-abbreviation.html?_sm_au_=iVVSF7NR5FZVFPZD
    public boolean validWordAbbreviation2(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }

}
