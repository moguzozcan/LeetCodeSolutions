/*
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



Example 1:

Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15
 */

public class LC_840_MagicSquaresInGrid {

    /*
    This is a basic question just to test if you can write code clearly and without an error. The complexity is O(NM)
    where N is the row and M is the column size of the given array. The space complexity is O(1), we do not store
    any value.
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int lenI = grid.length;
        int lenJ = grid[0].length;

        for(int i = 0; i < lenI - 2; i++) {
            for(int j = 0; j < lenJ - 2; j++) {
                if(isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }


    private boolean isMagicGrid(int[][] grid, int i, int j) {
        int[] numbers = new int[16];  // Since from 0 to 15
        numbers[grid[i][j]]++;
        numbers[grid[i + 1][j]]++;
        numbers[grid[i + 2][j]]++;
        numbers[grid[i][j + 1]]++;
        numbers[grid[i + 1][j + 1]]++;
        numbers[grid[i + 2][j + 1]]++;
        numbers[grid[i][j + 2]]++;
        numbers[grid[i + 1][j + 2]]++;
        numbers[grid[i + 2][j + 2]]++;

        for(int k = 1; k <= 9; k++) {
            if(numbers[k] != 1) {
                return false;
            }
        }

        int sum = 15;

        if(grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != sum) {
            return false;
        }

        if(grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != sum) {
            return false;
        }

        if(grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != sum) {
            return false;
        }

        //J axis
        if(grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != sum) {
            return false;
        }

        if(grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != sum) {
            return false;
        }

        if(grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != sum) {
            return false;
        }

        if(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != sum) {
            return false;
        }

        if(grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] != sum) {
            return false;
        }

        return true;
    }
}
