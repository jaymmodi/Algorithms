package DynamicProgramming;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int prices1[] = {7, 1, 5, 3, 6, 4};
        int prices2[] = {3, 1};
        int prices3[] = {1, 2, 3, 4, 5};
        int prices4[] = {2, 6, 5, 0, 3};
        int prices5[] = {1, 7, 4, 2};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println(maxProfit(prices4));
        System.out.println(maxProfit(prices5));
    }

    public static int maxProfit(int[] prices) {
        int profitMemory[] = new int[prices.length];
        return maxProfitHelper(prices, 0, profitMemory);
    }

    private static int maxProfitHelper(int[] prices, int start, int[] profitMemory) {
        if (start >= prices.length - 1) {
            if (start == prices.length - 1)
                profitMemory[start] = 0;

            return 0;
        }

        if (start == prices.length - 2) {
            profitMemory[start] = prices[start + 1] > prices[start] ? prices[start + 1] - prices[start] : 0;
            return profitMemory[start];
        }

        if (profitMemory[start] != 0) {
            return profitMemory[start];
        }

        int profit = 0;
        for (int buyingIndex = start; buyingIndex < (prices.length); buyingIndex++) {
            for (int sellingIndex = buyingIndex + 1; sellingIndex < prices.length; sellingIndex++) {
                int currentProfit = prices[sellingIndex] - prices[buyingIndex];

                profit = Math.max(profit, currentProfit + maxProfitHelper(prices, sellingIndex + 1, profitMemory));
            }
        }

        profitMemory[start] = profit < 0 ? 0 : profit;
        return profitMemory[start];
    }
}
