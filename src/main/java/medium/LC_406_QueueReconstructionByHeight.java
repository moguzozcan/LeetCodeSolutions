package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Difficulty: Medium
Companies: Google

Suppose you have a random list of people standing in a queue. Each person is described by a pair
of integers (h, k), where h is the height of the person and k is the number of people in front of
this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class LC_406_QueueReconstructionByHeight {

    /**
     * People are only counting (in their k-value) taller or equal-height others standing in front of them.
     * So a smallest person is completely irrelevant for all taller ones. And of all smallest people, the
     * one standing most in the back is even completely irrelevant for everybody else. Nobody is counting
     * that person. So we can first arrange everybody else, ignoring that one person. And then just insert
     * that person appropriately. Now note that while this person is irrelevant for everybody else,
     * everybody else is relevant for this person - this person counts exactly everybody in front of
     * them. So their count-value tells you exactly the index they must be standing.
     *
     * So you can first solve the sub-problem with all but that one person and then just insert that
     * person appropriately. And you can solve that sub-problem the same way, first solving the
     * sub-sub-problem with all but the last-smallest person of the subproblem. And so on. The base
     * case is when you have the sub-...-sub-problem of zero people. You're then inserting the people
     * in the reverse order, i.e., that overall last-smallest person in the very end and thus the
     * first-tallest person in the very beginning. That's what the above solution does, Sorting the
     * people from the first-tallest to the last-smallest, and inserting them one by one as appropriate.
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];
            return a[1]-b[1];
        });
        for(int[] a:people)
            list.add(a[1],a);
        int[][] res = new int[people.length][2];
        int i=0;
        for(int[] a: list) res[i++]=a;
        return res;
    }

    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
