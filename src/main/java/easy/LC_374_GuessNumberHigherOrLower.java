package easy;

/*
Difficulty: Easy
Companies: Google

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6
 */


/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */


public class LC_374_GuessNumberHigherOrLower {

    //The hint in this question is be able to implement a binary search.
    /*
    Complexity Analysis

    Time complexity : O\big(\log_2 n\big)O(log
    2
    ​
     n). Binary Search is used.
    Space complexity : O(1)O(1). No extra space is used.
     */
    public int guessNumber(int n) {

        int low = 1;
        int high = n;
        int mid = low + (high - low) / 2;  //Because of the integer overflow might happen, write the equation like this
        int result = guess(mid);
        while(result != 0) {
            if(result == 1) {
                high = mid - 1;
            } else if (result == -1) {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
            result = guess(mid);
        }

        return mid;
    }

    //Here we can also write the normal binary search method and check the guess method and finish the loop.
    public int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int guess(int num) {
        return 0;
    }
}
