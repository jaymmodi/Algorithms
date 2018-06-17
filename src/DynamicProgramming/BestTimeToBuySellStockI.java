package DynamicProgramming;

public class BestTimeToBuySellStockI {
    public static void main(String[] args) {
        int prices1[] = {7, 1, 5, 3, 6, 4};
        int prices2[] = {3, 1};
        int prices3[] = {1, 2, 3, 4, 5};
        int prices4[] = {2, 6, 5, 0, 3};
        int prices5[] = {1, 7, 4, 2};

        System.out.println(maxProfitSlower(prices1));
        System.out.println(maxProfitSlower(prices2));
        System.out.println(maxProfitSlower(prices3));
        System.out.println(maxProfitSlower(prices4));
        System.out.println(maxProfitSlower(prices5));

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println(maxProfit(prices4));
        System.out.println(maxProfit(prices5));
    }

    public static int maxProfitSlower(int[] prices) {
        int profit = 0;
        for (int buyingIndex = 0; buyingIndex <= prices.length - 2; buyingIndex++) {
            for (int sellingIndex = buyingIndex + 1; sellingIndex <= prices.length - 1; sellingIndex++) {
                int currentProfit = prices[sellingIndex] - prices[buyingIndex];

                profit = Math.max(profit, currentProfit);
            }
        }

        return profit;
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int minBuyingPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuyingPrice) {
                minBuyingPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - minBuyingPrice);
            }
        }

        return max;
    }
}
