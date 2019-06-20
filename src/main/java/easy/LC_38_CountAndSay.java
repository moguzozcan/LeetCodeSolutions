package easy;

/*
Difficulty: Easy
Companies: Facebook

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class LC_38_CountAndSay {

    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else if(n == 2) {
            return "11";
        }
        String str = "11";
        for(int i = 0; i < n - 2; i++) {
            str = countAndSay(str);
        }

        return str;
    }

    private String countAndSay(String str) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        int len = str.length();

        for(int i = 0; i < len - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(str.charAt(len - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        LC_38_CountAndSay lc_38_countAndSay = new LC_38_CountAndSay();
        System.out.println(lc_38_countAndSay.countAndSay(1));
        System.out.println(lc_38_countAndSay.countAndSay(2));
        System.out.println(lc_38_countAndSay.countAndSay(3));
        System.out.println(lc_38_countAndSay.countAndSay(4));
        System.out.println(lc_38_countAndSay.countAndSay(5));
    }
}
