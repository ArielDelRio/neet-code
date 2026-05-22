package arrayshashing.topkfrequentelements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {

    private final TopKFrequentElements solution = new TopKFrequentElements();

    @Test
    void example1() {
        int[] result = solution.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        assertEquals(2, result.length);
        assertTrue((result[0] == 2 && result[1] == 3) || (result[0] == 3 && result[1] == 2));
    }

    @Test
    void example2() {
        int[] result = solution.topKFrequent(new int[]{7, 7}, 1);
        assertEquals(1, result.length);
        assertEquals(7, result[0]);
    }

    @Test
    void allDistinct() {
        int[] result = solution.topKFrequent(new int[]{1, 2, 3, 4}, 2);
        assertEquals(2, result.length);
        assertTrue(result.length == 2);
    }

    @Test
    void singleElement() {
        int[] result = solution.topKFrequent(new int[]{1}, 1);
        assertEquals(1, result.length);
        assertEquals(1, result[0]);
    }

    @Test
    void allSameFrequency() {
        int[] result = solution.topKFrequent(new int[]{1, 1, 2, 2, 3, 3}, 2);
        assertEquals(2, result.length);
    }

    @Test
    void kEqualsDistinctElements() {
        int[] result = solution.topKFrequent(new int[]{4, 4, 4, 1, 1, 2}, 3);
        assertEquals(3, result.length);
    }

    @Test
    void negativeNumbers() {
        int[] result = solution.topKFrequent(new int[]{-1, -1, -2, -2, -2}, 2);
        assertEquals(2, result.length);
        assertTrue(contains(result, -2) && contains(result, -1));
    }

    private boolean contains(int[] arr, int num) {
        for (int val : arr) {
            if (val == num) {
                return true;
            }
        }
        return false;
    }
}
