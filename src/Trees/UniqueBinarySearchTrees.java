package Trees;

public class UniqueBinarySearchTrees {

    // Catalan number
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + numTrees(i) * numTrees(n - 1 - i);
        }

        return sum;
    }
}
