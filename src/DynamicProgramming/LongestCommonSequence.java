package DynamicProgramming;


public class LongestCommonSequence {


    public static void main(String[] args) {
        String a = "abcd";
        String b = "aeed";

        int helperMatrix[][] = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < helperMatrix.length; i++) {
            helperMatrix[i][0] = 0;
        }
        for (int i = 0; i < helperMatrix[0].length; i++) {
            helperMatrix[0][i] = 0;
        }

        System.out.println(countLongestCommonSequence(a, b, helperMatrix));
    }

    private static int countLongestCommonSequence(String a, String b, int[][] helperMatrix) {

//        for (int i = a.length() - 1; i >= 1; i--) {
//            for (int j = 0; j < b.length(); j++) {
//                if ()
//            }
//        }

        return helperMatrix[0][0];
    }
}
