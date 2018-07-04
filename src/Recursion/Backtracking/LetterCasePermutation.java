package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("12345"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        char[] current = new char[S.length()];
        letterCasePermutationHelper(S.toCharArray(), current, result, 0);

        return result;
    }

    private static void letterCasePermutationHelper(char[] available, char[] currentString, List<String> result, int index) {
        if (index == available.length) {
            result.add(new String(currentString));
        } else {
            char c = available[index];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                currentString[index] = Character.toLowerCase(c);
                letterCasePermutationHelper(available, currentString, result, ++index);

                --index;
                currentString[index] = Character.toUpperCase(c);
                letterCasePermutationHelper(available, currentString, result, ++index);
            } else {
                currentString[index] = c;
                letterCasePermutationHelper(available, currentString, result, ++index);
            }
        }


    }
}
