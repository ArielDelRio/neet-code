package arrayshashing.twosum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    @Test
    void example1() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 4, 5, 6}, 7));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[]{0, 2}, solution.twoSum(new int[]{4, 5, 6}, 10));
    }

    @Test
    void example3() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{5, 5}, 10));
    }

    @Test
    void negativeNumbers() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{-3, 3}, 0));
    }

    @Test
    void targetAtEnd() {
        assertArrayEquals(new int[]{2, 3}, solution.twoSum(new int[]{1, 2, 3, 4}, 7));
    }
}
