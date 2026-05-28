package slidingwindow.besttimetobuyandsellstock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockTest {

    private final BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    @Test
    void example1_shouldReturnSix() {
        assertEquals(6, solution.maxProfit(new int[] {10, 1, 5, 6, 7, 1}));
    }

    @Test
    void example2_shouldReturnZero() {
        assertEquals(0, solution.maxProfit(new int[] {10, 8, 7, 5, 2}));
    }

    @Test
    void singleDay_shouldReturnZero() {
        assertEquals(0, solution.maxProfit(new int[] {5}));
    }

    @Test
    void allEqualPrices_shouldReturnZero() {
        assertEquals(0, solution.maxProfit(new int[] {4, 4, 4, 4}));
    }

    @Test
    void profitAppearsAfterEarlyDrop_shouldReturnBestLaterGain() {
        assertEquals(4, solution.maxProfit(new int[] {9, 2, 6, 1, 5}));
    }

    @Test
    void zeroPriceCanBeBestBuy_shouldReturnMaximumProfit() {
        assertEquals(7, solution.maxProfit(new int[] {3, 0, 2, 0, 7}));
    }
}
