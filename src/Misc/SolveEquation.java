package Misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolveEquation {
    public static void main(String[] args) {
        System.out.println(solveEquation("3x=33+22+11"));
    }

    public static String solveEquation(String equation) {
        if (equation == null || equation.isEmpty()) {
            return "No Solution";
        }

        String[] split = equation.split("=");

        String left = split[0];
        String right = split[1];

        String regex = "([+-]?[\\d]*x?)";
        String numberRegex = "([+-]?[\\d]*)";

        Pattern pattern = Pattern.compile(regex);
        Pattern numberPattern = Pattern.compile(numberRegex);

        int lXSum = 0, lSum = 0;
        int rXSum = 0, rSum = 0;
        Matcher leftMatcher = pattern.matcher(left);

        while (leftMatcher.find()) {

            String group = leftMatcher.group();
            if (!group.isEmpty()) {
                Matcher numberMatcher = numberPattern.matcher(group);

                String number = "";
                if (numberMatcher.find()) {
                    number = numberMatcher.group(1);
                }

                if (group.equals("x")) {
                    lXSum++;
                } else if (group.contains("x")) {
                    if (number.isEmpty()) {
                        lXSum++;
                    } else if (number.equals("+")) {
                        lXSum++;
                    } else if (number.equals("-")) {
                        lXSum--;
                    } else {
                        lXSum += Integer.parseInt(number);
                    }
                } else {
                    lSum += Integer.parseInt(number);
                }
            }
        }

        Matcher rightMatcher = pattern.matcher(right);
        while (rightMatcher.find()) {

            String group = rightMatcher.group();
            if (!group.isEmpty()) {
                Matcher numberMatcher = numberPattern.matcher(group);

                String number = "";
                if (numberMatcher.find()) {
                    number = numberMatcher.group(1);
                }

                if (group.equals("x")) {
                    rXSum++;
                } else if (group.contains("x")) {
                    if (number.isEmpty()) {
                        rXSum++;
                    } else if (number.equals("+")) {
                        rXSum++;
                    } else if (number.equals("-")) {
                        rXSum--;
                    } else {
                        rXSum += Integer.parseInt(number);
                    }
                } else {
                    rSum += Integer.parseInt(number);
                }
            }
        }

        int finalXSum = lXSum - rXSum;
        int finalRightSum = rSum - lSum;

        if (finalXSum == 0 && finalRightSum == 0) {
            return "Infinite solutions";
        } else if (finalXSum == 0) {
            return "No solution";
        } else {
            return "x=" + finalRightSum/finalXSum;
        }
    }
}
