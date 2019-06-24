package medium;

/*
Difficulty: Medium
Companies: Facebook

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_56_MergeIntervals {

    /**
     Questions:
     1. Is the intervals are given sorted by the start time
     2. More than one arrays can be merged because of the overlapping?
     3. Does the return order matters?
     4. Input type is int or long?
     5. What is something like this happens?
     [1, 3], [2, 6] [4, 7]
     [1, 3], [2, 6] [3, 5]
     6. If one end is just at the same time as others start

     Thoughts:
     Two array should be merged if one end is bigger than others start;
     sort than look for the merged ones?
     get start and end times, then sort those arrays

     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for(Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        List<Interval> mergedList = new ArrayList<>();

        int len = starts.size();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(ends.get(i) >= starts.get(i)) {
                    //do nothing just loop
                } else {
                    Interval interval = new Interval();
                    interval.start = starts.get(i);
                    interval.end = ends.get(i);
                    i = j + 1;
                    mergedList.add(interval);
                }
            }
        }

        return mergedList;
    }

    class Interval {
        private int start;
        private int end;
    }

    /*
    for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
		if (i == n - 1 || starts[i + 1] > ends[i]) {
			res.add(new Interval(starts[j], ends[i]));
			j = i + 1;
		}
	}
     */
}
