package Misc;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
    }

    public static double myPow(double x, int n) {
        if (x == 1.0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE && x == -1.0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }

        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
