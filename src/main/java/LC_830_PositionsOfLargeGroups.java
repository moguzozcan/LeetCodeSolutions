/*
In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.



Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]


Note:  1 <= S.length <= 1000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_830_PositionsOfLargeGroups {

    /*
    I loop through the String characters and keep the current same char count, previous char and the start index of the
    same characters. Then I check if the current char is the same as the prev char, if yes, increment count, if not
    check whether the count is equal or more than 3, if yes add start and end index, which is i - 1, to the list, and
    make start index i, and current count as 1.
    The time complexity is O(N) since I loop through the string, and space complexity is also O(N) since the
    maximum list can store N / 3 data in worst case, if all the chars are sequenced with 3 same characters after each
    other, in this case space complexity is O(N/3) which is equal to O(N).
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> returnList = new ArrayList<>();

        List<Integer> tmpList = new ArrayList<>();

        int currentCount = 0;
        char prevChar = ' ';
        int startIndex = 0;

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if(c == prevChar) {
                currentCount++;

            } else {
                if(currentCount >= 3) {
                    tmpList.add(startIndex);
                    tmpList.add(i - 1);
                    returnList.add(tmpList);
                    tmpList = new ArrayList<>();
                }
                startIndex = i;
                prevChar = c;
                currentCount = 1;
            }
        }
        if(currentCount >= 3) {
            tmpList.add(startIndex);
            tmpList.add(S.length() - 1);
            returnList.add(tmpList);
        }

        return returnList;
    }

    /*
    The shorter solution is gathered form the leetcode solutions. They use two pointers for that.
     */
    public List<List<Integer>> largeGroupPositionsShorter(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}
