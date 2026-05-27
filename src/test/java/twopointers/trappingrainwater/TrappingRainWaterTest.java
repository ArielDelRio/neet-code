package twopointers.trappingrainwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    private final TrappingRainWater solution = new TrappingRainWater();

    @Test
    void example1() {
        assertEquals(9, solution.trap(new int[] { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 }));
    }

    @Test
    void minimumSize_singleBar() {
        assertEquals(0, solution.trap(new int[] { 5 }));
    }

    @Test
    void allZeros() {
        assertEquals(0, solution.trap(new int[] { 0, 0, 0, 0 }));
    }

    @Test
    void strictlyIncreasing() {
        assertEquals(0, solution.trap(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    void strictlyDecreasing() {
        assertEquals(0, solution.trap(new int[] { 5, 4, 3, 2, 1 }));
    }

    @Test
    void simpleBasin() {
        assertEquals(2, solution.trap(new int[] { 2, 0, 2 }));
    }
}
