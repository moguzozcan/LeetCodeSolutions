package easy;

/*
Design and implement a data structure for a compressed string iterator. It should support the following operations: next
and hasNext.
The given compressed string will be in the form of each letter followed by a positive integer representing the number of
this letter existing in the original uncompressed string.
next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.
Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across
multiple test cases. Please see here for more details.
Example:
StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '
*/

import java.util.ArrayList;
import java.util.List;

public class LC_604_DesignCompressedStringIterator {

    private String string;

    private int index, size;
    private List<Character> characters = new ArrayList<>();
    private List<Integer> counts = new ArrayList<>();

    public void StringIterator(String compressedString) {
        for(int i = 0; i < compressedString.length(); i++) {
            if(i % 2 == 0) {
                characters.add(compressedString.charAt(i));
            } else {
                counts.add(Character.getNumericValue(compressedString.charAt(i)));
            }
        }
    }

    public char next() {
        if(hasNext()) {
            if(counts.get(index) == 1) {
                index++;
                return characters.get(index - 1);
            } else {
                counts.set(index, counts.get(index) - 1);
                return characters.get(index);
            }
        } else {
            return ' ';
        }
    }

    public boolean hasNext() {
        return index < characters.size();
    }

}
