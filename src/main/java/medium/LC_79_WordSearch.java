package medium;

/*
Difficulty: Medium
Companies: Facebook

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class LC_79_WordSearch {

    /**
     * Questions:
     * 1. The same letter cell may not be used more than once
     * 2. Do we only have characters, letters, digits etc.
     *
     * The idea is to traverse all the elements of the 2d array which takes O(n^2) times,
     * Then for each elements, traverse each adjacent elements, also hold an index for the index of the character in the
     * searched word. If our index equals to the length of word then we successfully found a match. If the current
     * character does not match the characted of the word at the index or we are above and below the limit of our
     * arrays we should return true, for the visited nodes, we can either create a visited array 2d, and each time
     * check if we have visited that point, or just change the character to some awkward character and then replace it
     * with the original one after finishing all the four recursive methods.
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        //Check if board is not empty
        if(board.length == 0 || board[0].length == 0) {
            return false;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int horizontalIndex, int verticalIndex, int index) {
        int horizontalLimit = board.length;
        int verticalLimit = board[0].length;

        if(index == word.length()) {
            return true;
        }

        if(horizontalIndex > horizontalLimit - 1 || horizontalIndex < 0) {
            return false;
        }

        if(verticalIndex > verticalLimit -  1 || verticalIndex < 0) {
            return false;
        }
        if(board[horizontalIndex][verticalIndex] != word.charAt(index)) {
            return false;
        }

        board[horizontalIndex][verticalIndex] = '*';
        boolean result = helper(board, word, horizontalIndex - 1, verticalIndex, index + 1) ||
                helper(board, word, horizontalIndex, verticalIndex - 1, index + 1) ||
                helper(board, word, horizontalIndex + 1, verticalIndex, index + 1) ||
                helper(board, word, horizontalIndex, verticalIndex + 1, index + 1);

        board[horizontalIndex][verticalIndex] = word.charAt(index);
        return result;
    }
}
