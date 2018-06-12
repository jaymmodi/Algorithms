package DynamicProgramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int cost[] = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));

        int cost1[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost1));

    }

    public static int minCostClimbingStairs(int[] cost) {
        int minCost[] = new int[cost.length + 1];

        return minCostClimbingStairsHelper(cost, minCost, cost.length);
    }

    private static int minCostClimbingStairsHelper(int[] cost, int[] minCost, int index) {
        if (index <= 1) {
            return 0;
        }
        if (index == 2) {
            return Math.min(cost[0], cost[1]);
        }
        if (minCost[index] != 0) {
            return minCost[index];
        } else {
            minCost[index] = Math.min(cost[index - 1] + minCostClimbingStairsHelper(cost, minCost, index - 1), cost[index - 2] + minCostClimbingStairsHelper(cost, minCost, index - 2));

            return minCost[index];
        }

    }
}