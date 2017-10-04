package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {

    static int calls = 0;

    public static void main(String[] args) {
        printSum(4, 9);
    }

    private static void printSum(int dice, int sum) {
        List<Integer> chosen = new ArrayList<>();
        printSumHelper(chosen, dice, sum, 0);
        System.out.println("calls = " + calls);
    }

    private static void printSumHelper(List<Integer> chosen, int dice, int sum, int currentSum) {
        calls++;
        if (dice == 0) {
            if (sum == currentSum) {
                System.out.println(chosen);
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                if (currentSum + i + (dice - 1) <= sum && currentSum + i + (6 * (dice - 1)) >= sum) {
//                if (currentSum + i <= sum) {
                    //choose
                    chosen.add(i);
                    //explore
                    printSumHelper(chosen, dice - 1, sum, currentSum + i);
                    //un-choose -- this step is backtracking
                    chosen.remove(chosen.size() - 1);
                }
            }

        }
    }
}
