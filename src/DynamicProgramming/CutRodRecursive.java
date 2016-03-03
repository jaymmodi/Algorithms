package DynamicProgramming;


public class CutRodRecursive {

    public static void main(String[] args) {
        int cost[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(cost, 8));
    }

    private static int cutRod(int[] cost, int length) {
        if (length == 0) {
            return 0;
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= length - 1; i++) {
                max = Math.max(max, cost[i] + cutRod(cost, length - 1 - i));
            }
            return max;
        }
    }
}
