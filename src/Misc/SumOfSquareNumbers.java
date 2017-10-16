package Misc;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0));
    }

    public static boolean judgeSquareSum(int c) {
        boolean result = false;
        for (int i = 0; i <= Math.sqrt(c); i++) {
            result |= isPerfectSquare(c - i * i);
        }
        return result;
    }

    public static boolean isPerfectSquare(int num) {
        double root = Math.sqrt(num);

        return root - Math.floor(root) == 0.0;
    }
}
