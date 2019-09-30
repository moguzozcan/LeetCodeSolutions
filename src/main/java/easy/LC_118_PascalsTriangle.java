package easy;

/*
Difficulty: Easy
Companies: Amazon

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.ArrayList;
import java.util.List;

public class LC_118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if (numRows == 0) {
            return pascalTriangle;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        pascalTriangle.add(first);

        for (int row = 1; row < numRows; row++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            List<Integer> prevRow = pascalTriangle.get(row - 1);
            for (int i = 0; i < prevRow.size() - 1; i++) {
                currRow.add(prevRow.get(i) + prevRow.get(i + 1));
            }
            currRow.add(1);

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}
