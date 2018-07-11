/*
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
 */

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
      int loc = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
          nums[loc] = nums[i];
          loc++;
        }
      }
      return loc;
    }
}