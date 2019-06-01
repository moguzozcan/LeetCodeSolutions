package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */

public class LC_168_ExcelSheetColumnTitle {

    /**
     * This is I think not an easy solution. The idea is basically to use math divide and mod operation but in a
     * different way. We need to check if the current value is bigger than zero. Then, we need to decrease it by one,
     * because we start from 'A', when we need to find the character. Than we divide it with 26 and loop through.
     * At the end we return the reversed result.
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
