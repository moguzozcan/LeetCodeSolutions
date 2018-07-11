import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[2];
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    int diff;

    for (int i = 0; i < nums.length; i++) {
      diff = target - nums[i];
      if (map.containsKey(diff) && (map.get(diff) != i)) {
        res[0] = i;
        res[1] = map.get(diff);
        break;
      }
    }
    /*
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        diff = target - entry.getKey();
        if (map.containsKey(diff) && (map.get(diff) != entry.getValue())) {
            res[0] = entry.getValue();
            res[1] = map.get(diff);
            break;
        }
    }*/
    return res;
  }
}
