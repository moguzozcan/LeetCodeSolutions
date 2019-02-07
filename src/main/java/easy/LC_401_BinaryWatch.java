package easy;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

  Each LED represents a zero or one, with the least significant bit on the right.

  For example, the above binary watch reads “3:25”.

  Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

  Input: n = 1
  Return: [“1:00”, “2:00”, “4:00”, “8:00”, “0:01”, “0:02”, “0:04”, “0:08”, “0:16”, “0:32”]

Note:

  The order of output does not matter.
  The hour must not contain a leading zero, for example “01:00” is not valid, it should be “1:00”.
  The minute must be consist of two digits and may contain a leading zero, for example “10:2” is not valid, it should be “10:02”.

 */

import java.util.ArrayList;
import java.util.List;

public class LC_401_BinaryWatch {

    /*
    The idea is simply loop through all the possibilities and convert them to binary possibilities by using bitCount
    method of the Integer class. Since the upper limit is defined, the time complexity and space complexity are both
    O(1)
     */
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();

        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == num) {  // if(Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    /*
    Idea is for hour and minute, calculate and store all the possibilites and then, for each num, loop through all the
    possibilities and add them. The complexity is still O(1)
     */
    public List<String> readBinaryWatchOther(int num) {
        List<String> result = new ArrayList<String>();
        int hours[][] = {{0},{8,4,2,1},{3,5,9,6,10},{7,11}};
        int minutes[][] = {{0},{1,2,4,8,16,32},
                {3,5,9,17,33,6,10,18,34,12,20,36,24,40,48},
                {7,11,19,35,13,21,37,25,41,49,14,22,38,26,42,50,28,44,52,56},
                {15,23,39,27,43,51,29,45,53,57,30,46,54,58},
                {31,47,55,59}};

        for(int i = 0; i <= num && i <= 3; i++){
            if((num - i) >= 0 && (num - i) <= 5){
                for(int j : hours[i]){
                    for(int k : minutes[num-i]){
                        if(k<10)
                            result.add(j+":0"+k);
                        else
                            result.add(j+":"+k);
                    }
                }
            }
        }
        return result;
    }

/*
    String[][] hour = {{"0"},
            {"1", "2", "4", "8"},
            {"3", "5", "6", "9", "10"},
            {"7", "11"}};
    String[][] minute = {{"00"}, //1
            {"01", "02", "04", "08", "16", "32"}, //6
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"}, //15
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"}, //20
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"}, //14
            {"31", "47", "55", "59"}}; //4
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList();
        for (int i = 0; i <= 3 && i <= n; i++) {
            if (n - i <= 5) {
                for (String str1 : hour[i]) {
                    for (String str2 : minute[n - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;
    }*/

}
