package easy;

import java.util.ArrayList;
import java.util.List;

/*
Difficulty: Easy
Companies: Amazon

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/
public class LC_119_PascalsTriangleII {

    /**
     * Idea is very similar to the previous question except we only return the indexed row. \
     * Space complexity is O(2k) where k is the rowIndex, since we create currRow and we also have the return list
     * they add up to nearly 2k solution. This is close the O(k) solution.
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalTriangleRow = new ArrayList<>();
        pascalTriangleRow.add(1);

        if (rowIndex == 0) {
            return pascalTriangleRow;
        }

        for (int row = 1; row <= rowIndex; row++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            for (int i = 0; i < pascalTriangleRow.size() - 1; i++) {
                currRow.add(pascalTriangleRow.get(i) + pascalTriangleRow.get(i + 1));
            }
            currRow.add(1);

            pascalTriangleRow = currRow;
        }

        return pascalTriangleRow;
    }

    /**
     * The idea is create a fixed sized array list from the beginning. Then add 0 to beginning of the list in each
     * iteration. Then for each element between first and last, add current and next one and set them to the current
     * indexed position in the list. Then for the list add 1 to the beginning and update the result.
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowOKSpace(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    /**
     * The trick in this solution is to use a fixed sized array list from the beginning and then use i as the indicator
     * for the index.
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowOKSpaceBetter(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
