import java.util.HashMap;
import java.util.Map;

/**
 * 246. Strobogrammatic Number
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class LC_246_StrobogrammaticNumber {

    /**
     * The number should only contain 0, 1, 6, 8 and 9 digits, if that number contains anything else than it is not
     * strobogrammatic. If both characters are exist in the key of the map and value of one of the map is equal to
     * the key of the other map, then we are fine, if not exit the loop
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> strobogrammaticMap = new HashMap<>();

        strobogrammaticMap.put('0', '0');
        strobogrammaticMap.put('1', '1');
        strobogrammaticMap.put('6', '9');
        strobogrammaticMap.put('8', '8');
        strobogrammaticMap.put('9', '6');

        int i=0;
        int j = num.length()-1;
        while(i<=j){
            char f = num.charAt(i);
            char b = num.charAt(j);
            if(strobogrammaticMap.containsKey(f) && strobogrammaticMap.containsKey(b) && strobogrammaticMap.get(f) == b){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;

        /*

        int len = num.length();

        for(int i = 0; i < len - 1; i++) {
            if(!(num.charAt(i) == '1' || num.charAt(i) == '6' || num.charAt(i) == '8' || num.charAt(i) == '9')) {
                return false;
            }
        }

        for(int i = 0; i < len / 2; i++) {
            if(num.charAt(i) == '1' && num.charAt(len - 1 - i) != '1') {
                return false;
            }
            if(num.charAt(i) == '6' && num.charAt(len - 1 - i) != '9') {
                return false;
            }
            if(num.charAt(i) == '8' && num.charAt(len - 1 - i) != '8') {
                return false;
            }
            if(num.charAt(i) == '9' && num.charAt(len - 1 - i) != '6') {
                return false;
            }
        }*/

    }
}