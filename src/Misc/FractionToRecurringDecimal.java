package Misc;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(5, 3));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal((long) numerator, (long) denominator);

    }

    public static String fractionToDecimal(long numerator, long denominator) {
        boolean negative = false;
        if (numerator != 0) {
            negative = (numerator < 0) ^ (denominator < 0);
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        Map<Long, Integer> map = new HashMap<>(); // remainder, appear position
        StringBuilder answer = new StringBuilder();

        long positive = numerator / denominator;
        answer.append(positive);
        long remainder = numerator - positive * denominator;
        if (remainder == 0) {
            if (negative) {
                return "-" + String.valueOf(positive);
            }
            return String.valueOf(positive);
        }
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                answer.insert(map.get(remainder), "(");
                answer.append(")");
                break;
            }
            map.put(remainder, answer.length());
            remainder *= 10;
            answer.append(remainder / denominator);
            remainder = remainder - remainder / denominator * denominator;
        }

        answer.insert(String.valueOf(positive).length(), ".");
        if (negative) {
            answer.insert(0, "-");
        }
        return answer.toString();
    }
}
