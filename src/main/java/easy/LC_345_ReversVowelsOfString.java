package easy;

import java.util.ArrayList;
import java.util.List;

/*
Difficulty: Easy
Companies: Google

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */
public class LC_345_ReversVowelsOfString {


    public Character[] vowels = {'a', 'e', 'u', 'i', 'o', 'A', 'E', 'U', 'I', 'O'};

    public String reverseVowels(String s) {
        List<Character> vowelsInS = new ArrayList<>();

        for(Character c : s.toCharArray()) {
            if(contains(c)) {
                vowelsInS.add(c);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int vowelsIndex = vowelsInS.size() - 1;
        for(int i = 0; i < s.length(); i++) {
            if(contains(s.charAt(i))) {
                sb.setCharAt(i, vowelsInS.get(vowelsIndex));
                vowelsIndex--;
            }
        }

        return sb.toString();
    }

    private boolean contains(Character c) {
        for(Character ch : vowels) {
            if(c == ch) {
                return true;
            }
        }
        return false;
    }

    public String reverseVowelsFaster(String s) {
        char[] str = s.toCharArray();

        int si = 0;
        int ei = str.length - 1;

        while(si < ei) {
            while(si < ei && !isVowel(str[si])) {
                si++;
            }

            while(si < ei && !isVowel(str[ei])) {
                ei--;
            }

            char tmp = str[si];
            str[si] = str[ei];
            str[ei] = tmp;

            si++;
            ei--;
        }
        return String.valueOf(str);
    }

    private boolean isVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char ch : vowels) {
            if(c == ch) {
                return true;
            }
        }
        return false;
    }
}
