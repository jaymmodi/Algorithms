package DynamicProgramming;


public class CutRodDynamic {

    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

        int cost[] = new int[price.length];

        for (int i = 0; i < cost.length; i++) {
            cost[i] = -1;
        }

        cost[0] = 0;
        System.out.println(cutRod(price, cost, 8, Integer.MIN_VALUE));
    }

    private static int cutRod(int[] price, int[] cost, int length, int max) {
        if (length == 0) {
            return 0;
        }
        if (cost[length - 1] != -1) {
                return cost[length - 1];
        } else {
            for (int i = 0; i < length; i++) {
                max = Math.max(max, price[i] + cutRod(price, cost, length - 1 - i, max));
            }
            cost[length - 1] = max;
        }
        return cost[length - 1];
    }

}