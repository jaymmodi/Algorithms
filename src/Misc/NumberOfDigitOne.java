package Misc;

public class NumberOfDigitOne {

    public static void main(String[] args) {
        System.out.println(countDigitOne(1230));
    }

    private static int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }

        int length = String.valueOf(n).length();
        int[] array = new int[length + 1];
        array[0] = 0;
        array[1] = 1;

        if (length >= 2) {
            countDigitOneHelper(length, array);
        }

        int ones = 0;
        int factor = (int) Math.pow(10, length - 1);
        while (n > 0) {
            int quotient = n / factor;
            int remainder = n % factor;

            ones = ones + quotient * array[length - 1];
            if (quotient > 1) {
                ones = ones + factor;
            } else if (quotient == 1) {
                ones = ones + n - factor + 1;
            }

            factor = factor / 10;
            n = remainder;
            length = length - 1;
        }

        return ones;
    }

    private static int countDigitOneHelper(int length, int[] array) {
        if (array[length] > 0) {
            return array[length];
        }

        for (int i = 2; i < array.length; i++) {
            array[i] = 10 * countDigitOneHelper(i - 1, array) + (int) Math.pow(10, i - 1);
        }

        return array[length];
    }
}
