/*
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs,
determine if two sentences are similar.
For example, “great acting skills” and “fine drama talent” are similar, if the similar word pairs are
pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
Note that the similarity relation is not transitive. For example, if “great” and “fine” are similar, and “fine” and
“good” are similar, “great” and “good” are not necessarily similar.
However, similarity is symmetric. For example, “great” and “fine” being similar is the same as “fine” and “great” being
similar.
Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"],
pairs = []  are similar, even though there are no specified similar word pairs.
Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can
never be similar to words2 = ["doubleplus","good"].
Note:
The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_734_SentenceSimilarity {

    /*
    First of all, we need to make sure we have considered of all the edge cases in this question. So there are 3 conditions for a word:
    There is no similar pair exists for this word.
    There is one pair exists for this word.
    There are more than one pair exists for this word.
    Considering about all the above conditions, we need to use a one to more relationship when storing the pair relationship. This can be realized via a HashMap<String, HashSet<String>> for quick (O(1)) search for a word's similar words.
    And based on the question, we have two conditions when the two input arrays are not similar:
    The two input array are of different length.
    For a word at position i in words[], if this word does not exists in the HashMap or the HashSet corresponding to it does not contains words2[i]. Meanwhile, words1[i] != words2[i].
    Time complexity: O(n) where n is the greater one among words1.length and pairs.length.
    Space complexity: O(2*m) = O(m) where m is the length of pairs.
     */
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int len1 = words1.length;
        int len2 = words2.length;

        if(len1 != len2) {
            return false;
        }

        Map<String, Set<String>> pairsMap = new HashMap<>();

        for(String[] pair : pairs) {
            if(!pairsMap.containsKey(pair[0])) {
                pairsMap.get(pair[0]).add(pair[1]);
            }
            if(!pairsMap.containsKey(pair[1])) {
                pairsMap.get(pair[1]).add(pair[0]);
            }

            pairsMap.get(pair[0]).add(pair[1]);
            pairsMap.get(pair[1]).add(pair[0]);
        }

        for(int i = 0; i < len1; i++) {
            if(!words1[i].equals(words2[i])) {
                return false;
            }
            if(!pairsMap.containsKey(words1[i])) {
                return false;
            }
            if(!pairsMap.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}