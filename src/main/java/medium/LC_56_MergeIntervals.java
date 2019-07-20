package medium;

/*
Difficulty: Medium
Companies: Facebook, Google

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

import java.util.*;

public class LC_56_MergeIntervals {

    /**
     * Questions:
     * 1. Is the intervals are given sorted by the start time
     * 2. More than one arrays can be merged because of the overlapping?
     * 3. Does the return order matters?
     * 4. Input type is int or long?
     * 5. What is something like this happens?
     * [1, 3], [2, 6] [4, 7]
     * [1, 3], [2, 6] [3, 5]
     * 6. If one end is just at the same time as others start
     * <p>
     * Thoughts:
     * Two array should be merged if one end is bigger than others start;
     * sort than look for the merged ones?
     * get start and end times, then sort those arrays
     */
    public List<Interval> merge2(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        List<Interval> mergedList = new ArrayList<>();

        int len = starts.size();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (ends.get(i) >= starts.get(j)) {
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

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    class Interval {
        private int start;
        private int end;
    }

    //We can use: Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    public int[][] merge(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < starts.length; i++) {
            if(i == starts.length - 1 || starts[i + 1] > ends[i]) {

            }
        }
        return null;
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
