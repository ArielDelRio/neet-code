package arrayshashing.topkfrequentelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: min-heap by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: maintain top k frequent elements
        for (Integer num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: build result
        int[] result = new int[k];
        int idx = k - 1;
        while (!heap.isEmpty()) {
            result[idx--] = heap.poll();
        }
        return result;
    }
}
