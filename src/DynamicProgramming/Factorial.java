package DynamicProgramming;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(6));

        System.out.println(factorialDP(6));
    }

    private static int factorialDP(int number) {
        int memory[] = new int[number + 1];
        memory[0] = 0;
        memory[1] = 1;

        return factorialDPHelper(number, memory);
    }

    private static int factorialDPHelper(int number, int[] memory) {
        if (number <= 1) {
            return memory[number];
        }
        if (memory[number] != 0) {
            return memory[number];
        }

        int result = number * factorialDPHelper(number - 1, memory);
        memory[number] = result;

        return memory[number];
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
