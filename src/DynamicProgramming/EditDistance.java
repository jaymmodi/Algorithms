package DynamicProgramming;

public class EditDistance {

    public static void main(String[] args) {
        String from = "mahesh";
        String to = "jayesh";

        int helperMatrix[][] = new int[from.length() + 1][to.length() + 1];
        helperMatrix[0][0] = 0;

        for (int i = 1; i < helperMatrix.length; i++) {
            helperMatrix[i][0] = i;    //rows
        }

        for (int i = 0; i < helperMatrix[0].length; i++) {
            helperMatrix[0][i] = i;   //columns;
        }
        printMatrix(helperMatrix);
        System.out.println(findMinimumEditDistance(from, to, helperMatrix));
        printMatrix(helperMatrix);
    }

    private static int findMinimumEditDistance(String from, String to, int[][] helperMatrix) {

        for (int i = 1; i < helperMatrix.length; i++) {
            for (int j = 1; j < helperMatrix[0].length; j++) {
                if (from.charAt(i-1) == to.charAt(j-1)) {
                    helperMatrix[i][j] = helperMatrix[i - 1][j - 1];
                } else {
                    helperMatrix[i][j] = Math.min(Math.min(helperMatrix[i - 1][j - 1], helperMatrix[i][j - 1]), helperMatrix[i - 1][j])+1;
                }
            }
        }
        return helperMatrix[from.length()][to.length()];
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
