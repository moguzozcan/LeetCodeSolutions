package easy;

import java.util.HashMap;
import java.util.Map;

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class LC_447_NumberOfBumerangs {

    /*
    The idea is a bit trick, first thing that comes to mind is create three for loops for i, j and k and find equal
    distances. However, this is not a good solution. We need to use some space to decrease computational complexity.
    Idea is, use a map, whose keys are the distance between two points. Then for each i, find equal distance points and
    count them. Then for each i, there is permutation of count to 2 possible options for i,j,k's. Therefore, n * n - 1
    options exits for each i. At the end of the beginning loop, sum the value to the total and clear the map for the
    next iteration.
     */
    public int numberOfBoomerangs(int[][] points) {

        Map<Integer, Integer> boomerangs = new HashMap<>();
        int len = points.length;
        int count = 0;

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i != j) {
                    int distance = findDistance(points[i], points[j]);
                    if(boomerangs.containsKey(distance)) {
                        int value = boomerangs.get(distance);
                        boomerangs.put(distance, value + 1);
                    } else {
                        boomerangs.put(distance, 1);
                    }
                }
            }

            for(Map.Entry<Integer, Integer> entry : boomerangs.entrySet()) {
                int val = entry.getValue();
                count += val * (val - 1);
            }
            boomerangs.clear();
        }


        return count;
    }

    private int findDistance(int[] arr1, int[] arr2) {
        int distance = (int) Math.pow((arr1[0] - arr2[0]), 2) + (int) Math.pow((arr1[1] - arr2[1]), 2);
        return distance;
    }

}
