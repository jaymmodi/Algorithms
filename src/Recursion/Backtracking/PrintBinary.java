package Recursion.Backtracking;

public class PrintBinary {

    public static void main(String[] args) {
        printBinary(5);
    }

    private static void printBinary(int digits) {
        printBinary(digits, "");
    }

    private static void printBinary(int digits, String prefix) {
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            printBinary(digits - 1, prefix + "0");
            printBinary(digits - 1, prefix + "1");
        }
    }
}
