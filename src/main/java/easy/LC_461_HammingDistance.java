package easy;

/*
Difficulty: Easy
Companies: Facebook

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class LC_461_HammingDistance {

    /**
     * Idea is to use power of xor to only get different bits, since xor gives 1 for different bits and gives 0 for the
     * same bits. Then count how many 1's are there in the xor'ed number.
     *
     * Test cases:
     * Normal
     * All zeros,
     * All ones
     * Same numbers
     * 0 length
     * 2 to 31
     * If exceeds the limit of integer??? no it cannot?
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor >= 1) {
            if(xor % 2 == 1) {
                count++;
            }
            xor = xor / 2;
        }
        return count;
    }
}
