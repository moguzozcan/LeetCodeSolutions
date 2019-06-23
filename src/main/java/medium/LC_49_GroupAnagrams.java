package medium;

import java.util.*;

/*
Difficulty: Medium
Companies: Facebook

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class LC_49_GroupAnagrams {

    /**
     Ideas that pops to my mind:
     1. Sort each string lexicographically, than compare,
     2. Use a map which holds letters and their counts and this will be the key
     and the value of the map will be the indexes, then get all the values
     of the map and add them to lists of lists.
     3.

     The time complexity of this algorithm is O(NKlogK) where N is the
     length of strs array and K is the length of the maximum length string
     in strs.
     The space complexity of this algorithm is O(N)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();

        Map<String, List<Integer>> indexesMap = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(indexesMap.containsKey(sorted)) {
                indexesMap.get(sorted).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexesMap.put(sorted, indexList);
            }
        }

        for(Map.Entry<String, List<Integer>> entry: indexesMap.entrySet()) {

            List<Integer> anagramIndexesList = entry.getValue();
            List<String> groupList = new ArrayList<>();
            for(int i : anagramIndexesList) {
                groupList.add(strs[i]);
            }
            anagramGroups.add(groupList);
        }

        return anagramGroups;
    }

    /*
    Maintain a map ans : {String -> List} where each key \text{K}K is a sorted string, and each
    value is the list of strings from the initial input that when sorted, are equal to \text{K}K.

    In Java, we will store the key as a string, eg. code. In Python, we will store the key as a hashable
    tuple, eg. ('c', 'o', 'd', 'e').
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
