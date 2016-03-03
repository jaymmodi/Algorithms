package DynamicProgramming;

public class CoinChange {

    public static void main(String[] args) {
        int changeArray[] = {1, 2, 5, 10};
        int min = Integer.MAX_VALUE;

        int price = 19;
//        System.out.println(findMinimumChangeRecursive(changeArray, min, price));

        int savedArray[] = new int[price];
        for (int i = 0; i < savedArray.length; i++) {
            savedArray[i] = -1;
        }

        System.out.println(findMinimumDynamic(changeArray, savedArray, min, price));

    }

    private static int findMinimumDynamic(int[] changeArray, int[] savedArray, int min, int price) {
        if (price == 0) {
            return 0;
        } else if (pricePresentInArray(changeArray, price)) {
            return 1;
        } else if (savedArray[price - 1] != -1) {
            return savedArray[price - 1];
        } else {
            for (int i = 0; i < changeArray.length; i++) {
                if (price - changeArray[i] >= 0) {
                    min = Math.min(min, 1 + findMinimumDynamic(changeArray, savedArray, min, price - changeArray[i]));
                }
            }
        }
        return min;
    }

    private static int findMinimumChangeRecursive(int[] changeArray, int min, int price) {
        if (price == 0) {
            return 0;
        }
        if (pricePresentInArray(changeArray, price)) {
            return 1;
        } else {
            for (int i = 0; i < changeArray.length; i++) {
                if (price - changeArray[i] >= 0) {
                    min = Math.min(min, 1 + findMinimumChangeRecursive(changeArray, min, price - changeArray[i]));
                }
            }
        }

        return min;
    }

    private static boolean pricePresentInArray(int[] changeArray, int price) {

        for (int i = 0; i < changeArray.length; i++) {
            if (changeArray[i] == price) {
                return true;
            }
        }
        return false;
    }

}
