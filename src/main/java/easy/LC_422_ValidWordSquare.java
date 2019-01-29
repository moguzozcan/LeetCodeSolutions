package easy;/*
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

    /*
    This question gives us a two-digit array, each row and column is a word, the word that needs to satisfy the kth row
    and the word of the kth column are equal. There is no requirement that each word be the same length, as long as the
    corresponding position The same word can be. So here is actually a problem of traversing a two-dimensional array
    and then verifying whether the characters on the corresponding bits are equal. Since the lengths of the words in
    the lines are not necessarily equal, we must first judge whether the characters are out of bounds when we find
    the characters in the corresponding positions. Whether there is a character in the corresponding position, return
    false directly if it meets the requirements, and return true after all traversal, see the code as follows:
     */
    public boolean validWordSquare(List<String> words) {

        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}
