package easy;

import java.util.Arrays;
import java.util.Comparator;

/*
Difficulty: Easy
Companies: Facebook

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.
For example,
Given [[0, 30],[5, 10],[15, 20]], return false.
 */
public class LC_252_MeetingRooms {

    /**
     * Questions
     * 1. Are they given sorted?
     *      If not we need to check, we can sort wrt to start times
     *      If yes it is easy for us.
     * 2. What if end of one meeting is equal to the start time of the other?
     * 3. Are there any maximum number of meetings for a day, week etc? Or just int times?
     * 4. Do we need to check the correctness of the times provided?
     * 5. Input parameter is array of arrays or list of list? Same but.
     * The time complexity is O(NlogN) from sort and O(N) from traversing, so it is O(Nlog(N))
     * The space complexity is O(1)
     */

    public boolean couldAttendAllMeetings(Interval[] meetings) {

        Arrays.sort(meetings, ((o1, o2) -> {
            int diff = o1.start - o2.start;
            if(diff == 0) {
                return o1.end - o2.end;
            } else {
                return diff;
            }
        }));

        //Another way to sort the meetings array is override the compare method
        Arrays.sort(meetings, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };

        for(int i = 0; i < meetings.length - 1; i++) {
            if(meetings[i].end >= meetings[i + 1].start) {
                return false;
            }
        }

        return true;
    }

    class Interval {
        private int start;
        private int end;
    }

    //Another idea is without using the sorting with new comparator
    public boolean canAttendMeetings(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);
        int endT=0;
        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
    }
}
