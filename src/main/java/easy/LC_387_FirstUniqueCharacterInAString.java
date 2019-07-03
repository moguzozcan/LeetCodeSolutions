package easy;

/*
Difficulty: Easy
Companies: Google

Given a string, find the first non-repeating character in it and return it's index. If it doesn't
exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

import java.util.HashMap;
import java.util.Map;

public class LC_387_FirstUniqueCharacterInAString {

    private Map<Character, Integer> charCountMap = new HashMap<>();


    public int firstUniqChar(String s) {
        for(Character c : s.toCharArray()) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(charCountMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //Second solution which is faster

    class IndexRepeated {
        public int index;
        public boolean isRepeated;
    }

    public int firstUniqChar2(String s) {
        Map<Character, IndexRepeated> map = new HashMap<>();

        IndexRepeated ir;

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                ir = map.get(c);
                ir.isRepeated = true;
                map.put(c, ir);
            } else {
                ir = new IndexRepeated();
                ir.index = i;
                ir.isRepeated = false;
                map.put(c, ir);
            }
        }

        int index = -1;
        for(Map.Entry<Character, IndexRepeated> entry : map.entrySet()) {
            IndexRepeated ent = entry.getValue();
            if(!ent.isRepeated) {
                if (index == -1) {
                    index = ent.index;
                } else if(index > ent.index) {
                    index = ent.index;
                }
            }
        }
        return index;
    }
}
