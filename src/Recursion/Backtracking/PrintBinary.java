package Recursion.Backtracking;

public class PrintBinary {

    public static void main(String[] args) {
        printBinary(2);
    }

    private static void printBinary(int digits) {
        // exhaustive search
        // prefix - is the decisions I have taken
        printBinary(digits, "");
    }

    private static void printBinary(int digits, String prefix) {
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            // explore all options with the decision I have taken & decision is prefix
            printBinary(digits - 1, prefix + "0");
            printBinary(digits - 1, prefix + "1");
        }
    }
}
