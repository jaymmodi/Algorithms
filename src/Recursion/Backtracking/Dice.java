package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    public static void main(String[] args) {
        printAllPossibilities(3);
    }

    private static void printAllPossibilities(int numOfDice) {
        List<String> prefix = new ArrayList<>();
        printAllPossibilities(numOfDice, prefix);
    }

    private static void printAllPossibilities(int numOfDice, List<String> prefix) {
        if (numOfDice == 1) {
            System.out.println(String.join(",", prefix) + "," + 1);
            System.out.println(String.join(",", prefix) + "," + 2);
            System.out.println(String.join(",", prefix) + "," + 3);
            System.out.println(String.join(",", prefix) + "," + 4);
            System.out.println(String.join(",", prefix) + "," + 5);
            System.out.println(String.join(",", prefix) + "," + 6);
        } else {
            for (int i = 1; i <= 6; i++) {
                prefix.add("" + i);
                printAllPossibilities(numOfDice - 1, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }

    }
}
