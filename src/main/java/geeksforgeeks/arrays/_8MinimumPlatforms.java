package geeksforgeeks.arrays;

import java.util.*;

/*
Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of
platforms required for the railway station so that no train waits.
Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times
must not be same for a train.

Input:
The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N,
the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure
times respectively.
Note: Time intervals are in the 24-hour format(hhmm), preceding zeros are insignificant. 200 means 2:00.
Consider the example for better understanding of input.

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359

Example:
Input:
1
6
900  940 950  1100 1500 1800
910 1200 1120 1130 1900 2000

Output:
3

Explanation:
Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
 */
public class _8MinimumPlatforms {

    /*
    arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
    dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
     */
    public static int minPlatforms(int arr[], int dep[]) {
        int arrLen = arr.length;
        int depLen = dep.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        if (arrLen != depLen) {
            return -1;
        }

        int arrIndex = 1;
        int depIndex = 0;

        int max = 0;
        int current = 1;
        while (arrIndex != arrLen - 1 && depIndex != depLen - 1) {
            /*if(arr[arrIndex] == dep[depIndex]) { //What to do if the arrival of one train is same of departure of another train?
                arrIndex++;
                depIndex++;
            } else*/
            if (arr[arrIndex] <= dep[depIndex]) {
                current++;
                if (max < current) {
                    max = current;
                }
                arrIndex++;
            } else {
                current--;
                depIndex++;
            }
        }
        return max;
    }

    /*
    Tree map insertion is close to O(log(N))
     */
    public static int minPlatformsMap(int arr[], int dep[]) {
        Map<Integer, String> map = new TreeMap<>();

        for(int i : arr) {
            map.put(i, "a");
        }

        for(int i : dep) {
            map.put(i, "d");
        }

        int count = 0;
        int max = 0;
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getValue().equals("a")) {
                count++;
                if(max < count) {
                    max = count;
                }
            } else {
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minPlatforms(arr, dep));
        System.out.println(minPlatformsMap(arr, dep));
    }
}
