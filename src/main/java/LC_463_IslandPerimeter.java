/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class LC_463_IslandPerimeter {

    /*
    The idea is simple, a grid has 4 sides. Count the grids and multiply with 4. Then count adjacent grids, one adjacent
    grid tuple decrease two sides, one for each. Then count them horizontally and vertically. Multiply the total count
    with 2. Then result is 4 * grid - 2 * adjacent grids.
     */
    public int islandPerimeter(int[][] grid) {
        int totalGrid = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    totalGrid += 1;
                }
            }
        }

        totalGrid = totalGrid * 4;  //Each grid has 4 sides

        int sidedGrids = 0;
        //Horizontal adjacent grids
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length - 1; j++) {
                if(grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    sidedGrids += 1;
                }
            }
        }

        //Vertical adjacent grids
        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid.length - 1; j++) {
                if(grid[j][i] == 1 && grid[j + 1][i] == 1) {
                    sidedGrids += 1;
                }
            }
        }

        totalGrid = totalGrid - (2 * sidedGrids);

        return totalGrid;
    }
/*  A better solution from the discuss is, when find a grid, look at its right and bottom neighbors, if exist, then
    subtract with 2 * adjacent.
    loop over the matrix and count the number of islands;
    if the current dot is an island, count if it has any right neighbour or down neighbour;
    the result is islands * 4 - neighbours * 2*/
    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int islands = 0, neighbours = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        islands++; // count islands
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                    }
                }
            }

            return islands * 4 - neighbours * 2;
        }
    }
}
