package DynamicProgramming;


public class MaximumSumArray {

    public static void main(String[] args) {
        int array[] = {10,-10,-10};

        int sum = Integer.MIN_VALUE;
        int[] savedArray = new int[array.length];

        if (array[0] > 0) {
            savedArray[0] = array[0];
        } else {
            savedArray[0] = 0;
        }
        System.out.println(findMaxSumContinuousArray(array, sum, savedArray));
    }

    private static int findMaxSumContinuousArray(int[] array, int sum, int[] savedArray) {
        if (array.length == 0) {
            return 0;
        }

        for (int i = 1; i < array.length; i++) {
            if (savedArray[i - 1] + array[i] < 0) {
                savedArray[i] = 0;
            } else {
                savedArray[i] = savedArray[i - 1] + array[i];
            }
        }
        return findMaximumInArray(savedArray);
    }

    private static int findMaximumInArray(int[] savedArray) {
        int max = 0;
        for (int i = 0; i < savedArray.length; i++) {
            if (savedArray[i] > max) {
                max = savedArray[i];
            }
        }
        return max;
    }
}
