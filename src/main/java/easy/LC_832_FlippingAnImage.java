package easy;/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 */

public class LC_832_FlippingAnImage {

    /*
    My first solution is to do it exactly as said on the question. Doing the steps separately, the time complexity is
    O(N^2) since there are two for loops and the space complexity is O(1) the reversing is done in place.
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        //Flip horizontally
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n / 2; j++) {  //Go to half of the array and revert the array without extra space, in place
                int tmp = A[i][j];
                A[i][j] = A[i][n - j - 1];
                A[i][n - j - 1] = tmp;
            }
        }

        //Invert the array
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }

        return A;
    }

    /*
    This question can be solved shorter with the same time complexity. Just when flipping horizontally, also
    change the bits.
     */
    public int[][] flipAndInvertImageShorter(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
