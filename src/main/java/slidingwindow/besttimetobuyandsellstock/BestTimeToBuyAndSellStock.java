package slidingwindow.besttimetobuyandsellstock;

// Input: prices = [10,1,5,6,7,1]

// Output: 6

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int profit = 0;
        int minPriceDay = 0;
        int maxPriceDay = 1;

        while (maxPriceDay < prices.length) {
            profit = Math.max(profit, prices[maxPriceDay] - prices[minPriceDay]);
            if (prices[minPriceDay] > prices[maxPriceDay]) {
                minPriceDay = maxPriceDay;
            }
            maxPriceDay++;
        }

        return profit;
    }
}
