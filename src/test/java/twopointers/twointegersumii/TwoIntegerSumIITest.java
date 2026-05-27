package twopointers.twointegersumii;

import org.junit.jupiter.api.Test;

import twopointers.twointegersumii.TwoIntegerSumII;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoIntegerSumIITest {

    private final TwoIntegerSumII solution = new TwoIntegerSumII();

    @Test
    void example1_shouldReturnOneIndexedIndices() {
        assertArrayEquals(new int[] { 1, 2 }, solution.twoSum(new int[] { 1, 2, 3, 4 }, 3));
    }

    @Test
    void negatives_shouldWork() {
        assertArrayEquals(new int[] { 1, 3 }, solution.twoSum(new int[] { -5, -1, 2, 10 }, -3));
    }

    @Test
    void duplicates_shouldNotReuseSameIndex() {
        assertArrayEquals(new int[] { 1, 2 }, solution.twoSum(new int[] { 0, 0, 3, 4 }, 0));
    }

    @Test
    void targetAtEnds_shouldWork() {
        assertArrayEquals(new int[] { 1, 4 }, solution.twoSum(new int[] { -2, 0, 1, 3 }, 1));
    }

    @Test
    void allNegative_shouldWork() {
        assertArrayEquals(new int[] { 2, 3 }, solution.twoSum(new int[] { -10, -8, -2, -1 }, -10));
    }
}
