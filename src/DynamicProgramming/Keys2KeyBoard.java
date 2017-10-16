package DynamicProgramming;

public class Keys2KeyBoard {
    public static void main(String[] args) {
        System.out.println(minSteps(33));
    }

    public static int minSteps(int n) {
        if (n == 1)
            return 0;

        if (n == 2) {
            return 2;
        }

        int steps = 0;
        if (n % 2 == 0) {
            steps = minSteps(n / 2) + 2;
        } else {
            for (int i = n / 2; i >= 1; i--) {
                if (n % i == 0) {
                    int quotient = n / i;
                    steps = minSteps(i) + (quotient - 1) + 1;
                    break;
                }
            }
        }

        return steps;
    }
}
