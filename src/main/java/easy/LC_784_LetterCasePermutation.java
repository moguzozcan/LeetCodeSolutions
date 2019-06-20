package easy;

/*
Difficulty: Easy
Companies: Facebook

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_784_LetterCasePermutation {


    /**
     * The initial idea is implement permutation somehow, complexity will be O(N!) where N is the number of letters in
     * the string. Then return the list,
     * Need to distinguish letters and digits, assume nothing else is provided, we can use char = 'a' and char = 'Z'
     * the values between them for checking.
     * Real difficult part is how to implement permutation, we can use the recursion for that,
     * first distinguish if the character is letter,
     * then call the helper method for small and upper case versions and when reaching to the end of string add it to the list
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        List<String> permutations2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');

        helper(s.toCharArray(), 0, permutations);
        helper(s, sb, 0, permutations2);
        System.out.println(permutations);
        System.out.println(permutations2);
        return permutations;
    }

    private void helper(char[] chars, int index, List<String> permutations) {
        if(index == chars.length) {
            permutations.add(new String(chars));
        } else {
            if(Character.isLetter(chars[index])) {
                chars[index]=Character.toLowerCase(chars[index]);
                helper(chars, index+1, permutations);
                chars[index]=Character.toUpperCase(chars[index]);
            }
            helper(chars, index+1, permutations);
        }
    }

    private void helper(String s, StringBuilder sb, int index, List<String> permutations) {
        if(index == s.length()) {
            permutations.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            //return;
        } else if(s.charAt(index) < 'A' || s.charAt(index) > 'z') {
            sb.append(s.charAt(index));
            helper(s, sb, index+1, permutations);
            sb.deleteCharAt(sb.length() - 1);
        } else if(s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
            sb.append(s.charAt(index));
            helper(s, sb, index+1, permutations);
            sb.deleteCharAt(sb.length() - 1);
            char c = (char) ((int) s.charAt(index) - 32);
            sb.append(c);
            helper(s, sb, index+1, permutations);
        } else if(s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {
            helper(s, sb, index+1, permutations);
            sb.deleteCharAt(sb.length() - 1);
            char c = (char) ((int) s.charAt(index) + 32);
            sb.append(c);
            helper(s, sb, index+1, permutations);
        }
    }

    public static void main(String[] args) {
        LC_784_LetterCasePermutation lc_784_letterCasePermutation = new LC_784_LetterCasePermutation();
        String s = "a1b2";
        lc_784_letterCasePermutation.letterCasePermutation(s);
    }

    public List<String> letterCasePermutationBFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    public List<String> letterCasePermutationDFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }

}
