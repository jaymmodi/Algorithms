package Misc;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long reverse = 0;

        while (x / 10 != 0) {
            int unitsPlace = x % 10;
            reverse = reverse * 10 + unitsPlace;
            x = x / 10;
        }

        reverse = reverse * 10 + x;
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverse;
    }
}
