package arrayshashing.longestconsecutivesequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @Test
    void example1() {
        assertEquals(4, solution.longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5}));
    }

    @Test
    void example2() {
        assertEquals(7, solution.longestConsecutive(new int[]{0, 3, 2, 5, 4, 6, 1, 1}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, solution.longestConsecutive(new int[]{}));
    }

    @Test
    void singleElement() {
        assertEquals(1, solution.longestConsecutive(new int[]{42}));
    }

    @Test
    void allDuplicates() {
        assertEquals(1, solution.longestConsecutive(new int[]{5, 5, 5, 5}));
    }

    @Test
    void negativesAndZero() {
        assertEquals(4, solution.longestConsecutive(new int[]{-2, -1, 0, 1, 10}));
    }

    @Test
    void minAndMaxIntValues() {
        assertEquals(2, solution.longestConsecutive(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MAX_VALUE}));
    }
}
