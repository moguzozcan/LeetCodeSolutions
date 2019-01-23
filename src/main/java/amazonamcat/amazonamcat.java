package amazonamcat;

/*
Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent
cells (neighbors). An integer value of 1 represents an active cell and a value of 0 represents an inactive cell If the
neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the next day; otherwise
the cell becomes active The two cells on each end have a single adjacent cell, so assume that the unoccupied space on the
opposite side is an inactive cell. Even after updating the cell state, consider its previous state when updating the
state of other cells The state information of all cells should be updated simultaneously

Write an algorithm to output the state of the cells after the given number of days.

Input
The input to the function/method consists of two arguments:
states, a list of integers representing the current state of cells;
days, an integer representing the number of days.

Output
Return a list of integers representing the state of the cells after the given number of days.

Note
The elements of the list states contains 0s and 1s only
 */

import java.util.ArrayList;
import java.util.List;

public class amazonamcat {

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
//public class Solution

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<Integer> cellCompete(int[] states, int days)
        {
            // WRITE YOUR CODE HERE
            List<Integer> list = new ArrayList<>();

            int len = states.length;

            if(len == 1) {
                list.add(0);
                return list;
            }

            for(int i = 0; i < days; i++) {

                int[] newStates = new int[len];
                int prevState = 0;
                for(int j = 0; j < len; j++) {
                    if(j == 0) {
                        newStates[j] = 0 ^ states[j + 1];
                        prevState = states[j];
                    } else if(j == len - 1) {
                        newStates[j] = prevState ^ 0;
                    } else {
                        newStates[j] = prevState ^ states[j + 1];
                        prevState = states[j];
                    }
                }
                for(int k = 0; k < len; k++) {
                    states[k] = newStates[k];
                }
            }

            for(int in : states) {
                list.add(in);
            }
            return list;
        }
        // METHOD SIGNATURE ENDS
   // }
}
