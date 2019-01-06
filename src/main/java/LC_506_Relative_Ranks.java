/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
The idea is simple, but the question is a bit hard to understand. At the beginning I do not understand the question,
because the example given is confusing. However, the idea is that, we need to sort the array to get the order, we need
to sort in reverse order, descending way not the default ascending order. Then we need to keep the indexes of the sorted
and change them with the original array positions.
When I sort the array using Arrays.sort(), I was going to loose the original order, so I first store the array in a
backup array. Then I sort the array and convert it to reverse order. After that, I've created a map, which stores the
values as keys and their sorted order as value. Then using the map and the original array, I've filled a String array
with the relative rankings of the scores and if I encounter with the first three ranking, I filled them accordingly.
 */
public class LC_506_Relative_Ranks {

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;

        int[] backup = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);
        //Collections.reverse(Arrays.asList(nums));

        for (int i = 0; i < len / 2; ++i) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }

        Map<Integer, Integer> locationMap = new HashMap<>();

        int loc = 0;
        for (int i : nums) {
            locationMap.put(i, loc);
            loc++;
        }

        String[] arr = new String[len];
        int index = 0;
        for (int i : backup) {
            int location = locationMap.get(i);
            if (location == 0) {
                arr[index] = "Gold Medal";
            } else if (location == 1) {
                arr[index] = "Silver Medal";
            } else if (location == 2) {
                arr[index] = "Bronze Medal";
            } else {
                arr[index] = String.valueOf(location + 1);
            }
            index++;
        }
        return arr;
    }
}
