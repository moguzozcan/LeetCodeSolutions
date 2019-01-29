package easy;/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.
 */

public class LC_849_MaximizeDistanceToClosestPerson {

    /*If there are only one 1 then we need to look at its index
    and then we can get the max of the distance.

    If there are more than one 1, then we can run the algorithm,
    which is finding the max distance and return the distance.

    Approach #3: Group by Zero [Accepted]
    Intuition

    In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.

    Algorithm

    For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.

    For groups of empty seats between the edge of the row and one other person, the answer is K, and we should take into account those answers too.
    */
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;

        int adjacentZeros = 0;
        int currentCount = 0;
        int endAdjacentZeros = 0;
        int beginAdjacentZeros = 0;

        for(int i : seats) {
            if(i == 1) {
                if(adjacentZeros < currentCount) {
                    adjacentZeros = currentCount;
                }
                currentCount = 0;
            } else {
                currentCount++;
            }
        }

        if(currentCount != 0) {
            endAdjacentZeros = currentCount;
        }

        currentCount = 0;
        for(int i : seats) {
            if(i == 1) {
                beginAdjacentZeros = currentCount;
                break;
            } else {
                currentCount++;
            }
        }

        return Math.max(endAdjacentZeros, Math.max((adjacentZeros + 1) / 2, beginAdjacentZeros));
    }

    /*
    My first attempt which is not a very good solution
     */
    public int maxDistToClosest2(int[] seats) {
        int len = seats.length;

        int oneCount = 0;

        int maxDistance = 0;
        //int maxIndex = 0;


        for(int i = 0; i < len; i++) {
            if(seats[i] == 1) {
                oneCount++;
            }
        }

        if(oneCount == 1) {
            int index = 0;
            for(int i = 0; i < len; i++) {
                if(seats[i] == 1) {
                    index = i;
                }
            }
            if(index > len - index - 1) {
                return index;
            } else {
                return len - index - 1;
            }
        } else {
            int prevIndex = 0;
            for(int i = 0; i < len; i++) {
                if(seats[i] == 1) {
                    if(maxDistance < i - prevIndex) {
                        maxDistance = i - prevIndex;
                        //maxIndex = i;
                    }
                    prevIndex = i;
                }
            }
            if(maxDistance < (len - 1) - prevIndex) {
                maxDistance = (len - 1) - prevIndex;
                //maxIndex = len - 1;
            }

            return (maxDistance + 1 / 2);
            /*
            if((maxDistance - 1) % 2 == 0) {
                return (maxDistance / 2);  //maxIndex - (maxDistance / 2) - 1;
            } else {
                return //maxIndex - maxDistance / 2;
            }*/
        }
    }
}
