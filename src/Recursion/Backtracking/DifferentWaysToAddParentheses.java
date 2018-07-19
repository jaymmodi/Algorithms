package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {

        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
        System.out.println(diffWaysToCompute("4*5"));
        System.out.println(diffWaysToCompute("5"));
//        System.out.println(diffWaysToCompute("-5+6"));
        System.out.println(diffWaysToCompute("6-5"));
        System.out.println(diffWaysToCompute("15+15*20"));

    }

    public static List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memory = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if (isNumber(input, 0, input.length() - 1)) {
            result.add(Integer.parseInt(input));
            return result;
        }

        return helper(input, 0, input.length() - 1, memory);
    }

    private static boolean isNumber(String input, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isOperator(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> helper(String input, int start, int end, Map<String, List<Integer>> memory) {
        if (end >= start && isNumber(input, start, end)) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(Integer.parseInt(input.substring(start, end + 1)));
            return numbers;
        }
        if (memory.containsKey(input)) {
            return memory.get(input);
        } else {
            List<Integer> result = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                if (isOperator(input.charAt(i))) {
                    char operator = input.charAt(i);
                    List<Integer> leftResults = helper(input, start, i - 1, memory);
                    List<Integer> rightResults = helper(input, i + 1, end, memory);

                    for (Integer left : leftResults) {
                        for (Integer right : rightResults) {
                            result.add(calculate(operator, left, right));
                        }
                    }
                    memory.put(input.substring(start, end), result);

                }
            }

            return result;
        }
    }

    private static Integer calculate(char operator, Integer left, Integer right) {
        if (operator == '-') {
            return left - right;
        }
        if (operator == '+') {
            return left + right;
        }
        return left * right;
    }

    private static boolean isOperator(char c) {
        return c == '*' || c == '-' || c == '+';
    }
}
