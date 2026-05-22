package arrayshashing.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int complement = target - nums[idx];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), idx};
            }
            map.put(nums[idx], idx);
        }

        throw new IllegalArgumentException("No valid pair found for the given input");
    }
}
