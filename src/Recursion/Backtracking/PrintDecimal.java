package Recursion.Backtracking;

public class PrintDecimal {

    public static void main(String[] args) {
        printDecimal(3);
    }

    private static void printDecimal(int digits) {
        printDecimal(digits, "");
    }

    private static void printDecimal(int digits, String prefix) {
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < 10; i++) {
                printDecimal(digits - 1, prefix + String.valueOf(i));
            }
        }
    }
}
