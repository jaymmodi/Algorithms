package Misc;

public class PowerOf3 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }

    public static boolean isPowerOfThree(int n) {
            if (n == 0) {
                return false;
            }

            double v = Math.log10(n) / Math.log10(3);

            return v == Math.floor(v);
    }
}
