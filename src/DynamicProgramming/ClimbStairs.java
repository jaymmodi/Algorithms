package DynamicProgramming;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }
        int memory[] = new int[n + 1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;

        return climbStairsHelper(n, memory);
    }

    private static int climbStairsHelper(int n, int[] memory) {
        if (memory[n] != 0) {
            return memory[n];
        }

        int result = climbStairsHelper(n - 1, memory) + climbStairsHelper(n - 2, memory);
        memory[n] = result;
        return memory[n];
    }
}
