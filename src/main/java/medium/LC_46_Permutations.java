package medium;

import java.util.ArrayList;
import java.util.List;

/*
Difficulty: Medium
Companies: Google

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class LC_46_Permutations {

    /**
     * In every position, every number that is not been used before can exist.
     * The idea is to use backtracking and for every location put the elements that are not
     * already used before and call the method again. The exit case is if our temporary list size
     * is the same as the given array size. Also, do not forget to add the temporary list as the
     * new array list, since then you will modify it and this will break the code.
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

        backtrack(permutations, tmpList, nums);
        return permutations;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> tmpList, int[] nums) {
        if(tmpList.size() == nums.length) {
            permutations.add(new ArrayList(tmpList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(tmpList.contains(nums[i])) {
                continue;
            }
            tmpList.add(nums[i]);
            backtrack(permutations, tmpList, nums);
            tmpList.remove(tmpList.size() - 1);
        }

    }
}
