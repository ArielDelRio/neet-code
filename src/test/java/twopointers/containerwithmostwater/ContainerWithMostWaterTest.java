package twopointers.containerwithmostwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    void example1() {
        assertEquals(36, solution.maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6}));
    }

    @Test
    void example2_allEqual() {
        assertEquals(4, solution.maxArea(new int[]{2, 2, 2}));
    }

    @Test
    void minimumSize_twoBars() {
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
    }

    @Test
    void zerosPresent() {
        assertEquals(4, solution.maxArea(new int[]{0, 2, 0, 2, 0}));
    }

    @Test
    void strictlyIncreasing() {
        assertEquals(6, solution.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void strictlyDecreasing() {
        assertEquals(6, solution.maxArea(new int[]{5, 4, 3, 2, 1}));
    }
}
