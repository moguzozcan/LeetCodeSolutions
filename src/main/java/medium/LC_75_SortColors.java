package medium;

/*
Difficulty: Medium
Companies: Facebook

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
public class LC_75_SortColors {

    /**
     * This question is similar to Dutch National Flag Algorithm. We partition the array into subproblems and
     * sort the array in linear time.
     *
     * 3-way quicksort
     *
     *
     * @param colors
     */
    public void sortColors(int[] colors) {
        int zeroIndex = 0;
        int twoIndex = colors.length - 1;
        int i = 0;

        while(i <= twoIndex) {
            if(colors[i] == 0) {
                int tmp = colors[zeroIndex];
                colors[zeroIndex] = colors[i];
                colors[i] = tmp;
                zeroIndex++;
                i++;
            } else if(colors[i] == 2) {
                int tmp = colors[twoIndex];
                colors[twoIndex] = colors[i];
                colors[i] = tmp;
                twoIndex--;
            } else {
                i++;
            }
        }
    }

    /**
     * This method is based on the counting sort algorithm. It firstly counts the number of elements in a specific range
     * Then it places each element to the specific position. https://www.geeksforgeeks.org/counting-sort/
     * @param colors
     */
    public void sortColors2(int[] colors) {
        int count0=0, count1=0, count2=0;

        for(int i : colors) {
            if(i == 0) {
                count0++;
            } else if(i == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for(int i = 0; i < colors.length; i++) {
            if(i < count0) {
                colors[i] = 0;
            } else if(i >= count0 && i < count1) {
                colors[i] = 1;
            } else {
                colors[i] = 2;
            }
        }
    }
}
