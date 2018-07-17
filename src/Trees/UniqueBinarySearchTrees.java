package Trees;

public class UniqueBinarySearchTrees {

    // Catalan number
    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }

    public static int numTrees(int n) {
        int memory[] = new int[n+1];
        memory[0] =1;
        if(n >= 1){
            memory[1] =1;
        }

        return numTreesHelper(n, memory);
    }

    private static int numTreesHelper(int n, int[] memory){
        if(memory[n]!=0){
            return memory[n];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + numTreesHelper(i, memory) * numTreesHelper(n - 1 - i, memory);
        }

        memory[n] = sum;
        return sum;
    }
}
