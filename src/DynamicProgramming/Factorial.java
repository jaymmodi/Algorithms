package DynamicProgramming;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(6));
    }

    private static int factorialRecursive(int number) {
        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return number * factorialRecursive(number - 1);
    }
}
