package DynamicProgramming;

public class Keys2KeyBoard {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }

    public static int minSteps(int n) {
        int[] memory = new int[n + 1];
        memory[0] = 0;
        memory[1] = 0;

        if (n >= 2) {
            memory[2] = 2;
        }

        if (n >= 3) {
            for (int i = 3; i < memory.length; i++) {
                memory[i] = Integer.MIN_VALUE;
            }
            return minStepsDynamic(n, memory);
        } else {
            return memory[n];
        }
    }

    public static int minStepsDynamic(int n, int[] memory) {
        if (memory[n] > 0) {
            return memory[n];
        }

        int steps = 0;
        if (n % 2 == 0) {
            steps = minStepsDynamic(n / 2, memory) + 2;
        } else {
            for (int i = n / 2; i >= 1; i--) {
                if (n % i == 0) {
                    int quotient = n / i;
                    steps = minStepsDynamic(i, memory) + (quotient - 1) + 1;
                    break;
                }
            }
        }
        memory[n] = steps;
        return steps;
    }

    public static int minStepsRecursive(int n) {
        if (n == 1)
            return 0;

        if (n == 2) {
            return 2;
        }

        int steps = 0;
        if (n % 2 == 0) {
            steps = minStepsRecursive(n / 2) + 2;
        } else {
            for (int i = n / 2; i >= 1; i--) {
                if (n % i == 0) {
                    int quotient = n / i;
                    steps = minStepsRecursive(i) + (quotient - 1) + 1;
                    break;
                }
            }
        }

        return steps;
    }
}
