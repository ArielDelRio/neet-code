package arrayshashing.productsofarrayexceptself;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ProductsofArrayExceptSelfTest {

    private final ProductsofArrayExceptSelf solution = new ProductsofArrayExceptSelf();

    @Test
    void example1() {
        int[] result = solution.productExceptSelf(new int[]{1, 2, 4, 6});
        assertArrayEquals(new int[]{48, 24, 12, 8}, result);
    }

    @Test
    void example2() {
        int[] result = solution.productExceptSelf(new int[]{-1, 0, 1, 2, 3});
        assertArrayEquals(new int[]{0, -6, 0, 0, 0}, result);
    }

    @Test
    void oneZeroInArray() {
        int[] result = solution.productExceptSelf(new int[]{1, 0, 4, 2});
        assertArrayEquals(new int[]{0, 8, 0, 0}, result);
    }

    @Test
    void twoZerosInArray() {
        int[] result = solution.productExceptSelf(new int[]{0, 3, 0, 5});
        assertArrayEquals(new int[]{0, 0, 0, 0}, result);
    }

    @Test
    void minimumSizeArray() {
        int[] result = solution.productExceptSelf(new int[]{2, 3});
        assertArrayEquals(new int[]{3, 2}, result);
    }

    @Test
    void allNegativeNumbers() {
        int[] result = solution.productExceptSelf(new int[]{-1, -2, -3, -4});
        assertArrayEquals(new int[]{-24, -12, -8, -6}, result);
    }
}
