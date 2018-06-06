package Strings;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw"));
    }

    public static boolean backspaceCompare(String S, String T) {
        int endOne = S.length() - 1;
        int endTwo = T.length() - 1;

        while (endOne >= 0 && endTwo >= 0) {
            if (S.charAt(endOne) != '#' && T.charAt(endTwo) != '#') {
                if (S.charAt(endOne) == T.charAt(endTwo)) {
                    endOne--;
                    endTwo--;
                } else {
                    return false;
                }
            } else if (S.charAt(endOne) == '#' && T.charAt(endTwo) == '#') {
                int hashCountOne = 1;
                int hashCountTwo = 1;
                endOne--;
                endTwo--;

                while (S.charAt(endOne) == '#') {
                    hashCountOne++;
                    endOne--;
                }

                int jumpIndexOne = endOne - hashCountOne;
                for (int i = endOne; i >= jumpIndexOne; i--) {
                    if (S.charAt(i) == '#') {
                        hashCountOne++;
                    }
                }

                endOne = endOne - hashCountOne;

                while (T.charAt(endTwo) == '#') {
                    hashCountTwo++;
                    endTwo--;
                }

                int jumpIndexTwo = endTwo - hashCountTwo;
                for (int i = endTwo; i >= jumpIndexTwo; i--) {
                    if (T.charAt(i) == '#') {
                        hashCountTwo++;
                    }
                }

                endTwo = endTwo - hashCountTwo;
            } else if (S.charAt(endOne) == '#' && T.charAt(endTwo) != '#') {
                int hashCountOne = 1;
                endOne--;

                while (S.charAt(endOne) == '#') {
                    hashCountOne++;
                    endOne--;
                }


                int jumpIndexOne = endOne - hashCountOne;
                for (int i = endOne; i >= jumpIndexOne; i--) {
                    if (S.charAt(i) == '#') {
                        hashCountOne++;
                    }
                }

                endOne = endOne - hashCountOne;
            } else if (S.charAt(endOne) != '#' && T.charAt(endTwo) == '#') {
                int hashCountTwo = 1;
                endTwo--;

                while (T.charAt(endTwo) == '#') {
                    hashCountTwo++;
                    endTwo--;
                }

                int jumpIndexTwo = endTwo - hashCountTwo;
                for (int i = endTwo; i >= jumpIndexTwo; i--) {
                    if (T.charAt(i) == '#') {
                        hashCountTwo++;
                    }
                }

                endTwo = endTwo - hashCountTwo;
            }
        }
        return true;
    }
}
