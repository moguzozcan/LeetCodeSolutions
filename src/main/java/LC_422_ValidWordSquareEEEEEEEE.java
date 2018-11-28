/*
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Note:

The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Example 2:

Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Example 3:

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output:
false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.
 */

import java.util.List;

public class LC_422_ValidWordSquare {

    public boolean validWordSquare(List<String> words) {

        int row = words.size();
        int column = words.get(0).length();

        if(words.size() == 0 || words == null) {
            return true;
        }

        if(row != column) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        String currWord;
        for(int i = 0; i < row; i++) {
            currWord = words.get(i);
            for(int j = 0; i < words.get(i).length(); j++) {
                sb.append(words.get(j).charAt(i));
            }
            if(!currWord.equals(sb.toString())) {
                return false;
            }
            sb.delete(0, sb.length() -1);
        }
        return true;
    }
}
