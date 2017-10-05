package Misc;

public class TrailingZerosFactorial {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }


    public static int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        return n / 5 + trailingZeroes(n / 5);
    }
}
