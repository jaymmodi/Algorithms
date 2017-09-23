package Recursion.Backtracking;

public class Permutation {

    public static void main(String[] args) {
        String str = "jay";

        permute(str);
    }

    private static void permute(String str) {
        char[] chars = str.toCharArray();
        boolean[] visited = new boolean[chars.length];

        for (int i = 0; i < chars.length; i++) {
            visited[i] = true;
            permute(chars, visited, "" + chars[i]);
            visited[i] = false;
        }
    }

    private static void permute(char[] chars, boolean[] visited, String currentString) {
        if (currentString.length() == chars.length) {
            System.out.println(currentString);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    currentString = currentString + String.valueOf(chars[i]);

                    permute(chars, visited, currentString);

                    visited[i] = false;
                    currentString = currentString.substring(0, currentString.length() - 1);
                }
            }
        }
    }
}
