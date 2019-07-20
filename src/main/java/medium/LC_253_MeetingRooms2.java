package medium;

import java.util.TreeMap;

/*
Difficulty: Medium
Companies: Facebook

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
(si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */
public class LC_253_MeetingRooms2 {

    public int meetingRooms(int[][] intervals) {

        int len = intervals.length;

        int[] startTimes = new int[len];
        int[] endTimes = new int[len];

        for (int i = 0; i < len; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        int count = 0;

        int startIndex = 0;
        int endIndex = 1;

        return count;
    }

    public int meetingRooms(Interval[] intervals) {
        if(intervals.length == 0 || intervals == null) {
            return 0;
        }

        TreeMap<Integer, Integer> times = new TreeMap<>();

        for(Interval interval : intervals) {
            if(times.containsKey(interval.start)) {
                times.put(interval.start, times.get(interval.start) + 1);
            } else {
                times.put(interval.start, 1);
            }

            if(times.containsKey(interval.end)) {
                times.put(interval.end, times.get(interval.end) - 1);
            } else {
                times.put(interval.end, -1);
            }
        }

        int max = 0;
        int count = 0;

        for(Integer value: times.values()) {
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }

    class Interval {
        int start;
        int end;
    }
}
