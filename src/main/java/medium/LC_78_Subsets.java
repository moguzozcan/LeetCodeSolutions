package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Difficulty: Medium
Companies: Facebook

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class LC_78_Subsets {

    /**
     * Questions:
     * 1. Can we return subsets in any order
     * 2. Since all the elements are unique given in the questions, we should not have a duplicate subset
     * 3. What should we return if the given array is null, contains zero element
     * 4.
     *
     * The idea is for each element, we will either add or not add that element. Implement according to this idea.
     * Also very important point, when adding current list to the list of list, create new list, since in that case
     * it will just contain a pointer to that list which will be empty at the end.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        helper(subsetsList, new ArrayList<>(), 0, nums);

        return subsetsList;
    }

    private void helper(List<List<Integer>> subsets, List<Integer> tmp, int index, int[] nums) {
        if(index == nums.length) {
            subsets.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[index]);
        helper(subsets, tmp, index + 1, nums);

        tmp.remove(tmp.size() - 1);
        helper(subsets, tmp, index + 1, nums);
    }

    public List<List<Integer>> iterativeSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetsList = new ArrayList<>();

        subsetsList.add(new ArrayList<>());  //Add empty result

        List<List<Integer>> tmpRes = new ArrayList<>();
        for(int num : nums) {
            for(List<Integer> subset : subsetsList) {
                List<Integer> tmpSubSet = new ArrayList<>(subset);
                tmpSubSet.add(num);
                tmpRes.add(tmpSubSet);
            }
            subsetsList.addAll(tmpRes);
        }


        return subsetsList;
    }

    /*
    Another solution could be

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) { return ans; }
        Arrays.sort(nums);  // non-descending order
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<Integer>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }

    A good comment: https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

    Iterative solutions:
    https://leetcode.com/problems/subsets/discuss/27279/Simple-Java-Solution-with-For-Each-loops

    https://leetcode.com/problems/subsets/discuss/27294/Simple-iteration-(no-recursion-no-twiddling)-%2B-explanation
     */
}
