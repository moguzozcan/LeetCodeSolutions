/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */

public class LC_551_StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        char[] sArr = s.toCharArray();

        int countOfA = 0;
        int countOfL = 0;

        for(char c : sArr) {
            if(c == 'A') {
                countOfA++;
                if(countOfA == 2) {
                    return false;
                }
                countOfL = 0;
            } else if(c == 'L') {
                countOfL++;
                if(countOfL == 3) {
                    return false;
                }
            } else {
                countOfL = 0;
            }
        }
        return true;
    }

    /*
    There can also be a solution using regex, if there are three consequtive L's or two A's, then false, else true
     */
    public boolean checkRecordRegex(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
