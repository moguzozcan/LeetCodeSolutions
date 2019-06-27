package easy;

/*
Difficulty: Easy
Companies: Google

Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the
elements in A.
We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
These lists A and B may contain duplicates. If there are multiple answers, output any of them.
For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]

We should return

[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of Appears at B[4], and
so on. Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_760_FindAnagramMappings {

    /*
    Assumption 1: Assume A and B lengths are always equal.
    Assumption 2: Always there is a solution.
    When I was solving the problem, I assume there are duplicates and the duplicates causes collision in the Map.
    Therefore, I store integer to List in the map, and then I remove the elements from the list when I use them
    to create the return array. However, the solutions in the internet, do not consider this situation.
     */
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;

        List<Integer> returnList = new ArrayList<>();

        Map<Integer, List<Integer>> bMap = new HashMap<>();

        for(int i = 0; i < len; i++) {
            int element = B[i];

            if(!bMap.containsKey(element)) {
                bMap.put(element, new ArrayList<>());
            }

            bMap.get(element).add(i);
        }

        for(int i : A) {
            returnList.add(bMap.get(i).get(bMap.size() - 1));
            bMap.get(i).remove(bMap.size() - 1);
        }

        return returnList.stream().mapToInt(i->i).toArray();
    }

    public int[] anagramMappings2(int[] A, int[] B) {
        Map<Integer, Integer> lookup = new HashMap();

        for(int i = 0; i < B.length; i++)
            lookup.put(B[i], i);

        int[] ans = new int[A.length];
        for(int j = 0; j < ans.length; j++)
            ans[j] = lookup.get(A[j]);

        return ans;
    }

}
