package Misc;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(15));
    }

    public static boolean isPerfectSquare(int num) {
        double root = Math.sqrt(num);

        return root - Math.floor(root) == 0.0;
    }
}
