package easy;/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is
simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

import java.util.HashMap;
import java.util.Map;

public class LC_13_RomantoInteger {

    /*
    Idea is store all the characters and their int values in a map, then loop the string and compare the current and
    the next character. If the next character is bigger then the current one, then subtract current one from the
    next one add them to the total. If not add the current one to the total and continue.
     */
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>() ;
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int currTotal;

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2;

            Integer i1 = null, i2 = null;
            if(i != s.length() - 1) {
                c2 = s.charAt(i + 1);
                i2 = romanMap.get(c2);
            }

            i1 = romanMap.get(c1);

            if(i2 != null) {
                if(i2 > i1) {
                    total += i2 - i1;
                    i++;
                } else {
                    total += i1;
                }
            } else {
                total += i1;
            }
        }

        return total;
    }

    //A clearer solution
    public int romanToInt2(String s) {

        Map<Character, Integer> romanMap = new HashMap<>() ;
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int currTotal;

        for(int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            int i1 = romanMap.get(c1);
            int i2 = romanMap.get(c2);

            if(i2 > i1) {
                total -= i1;
            } else {
                total += i1;
            }
        }

        total += romanMap.get(s.charAt(s.length() - 1));

        return total;
    }

}
