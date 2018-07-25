package Recursion;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    /**
     * I 1
     * V 5
     * X 10
     * L 50
     * C 100
     * D 500
     * M 1000
     * <p>
     * I can appear only before V and X to give
     * <p>
     * IV 4
     * IX 9
     * <p>
     * X can appear only before L and C to give
     * <p>
     * XL 40
     * XC 90
     * <p>
     * C can appear only before D and M to give
     * <p>
     * CD 400
     * CM 900
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convert(1994));

        /**
         *
         * 99
         *
         * 90 + 9
         * 90 + 9
         * XC + V + IV
         *
         *
         *
         */
    }

    public static String convert(int num) {
        Map<Integer, String> symbols = new HashMap<>();
        symbols.put(1, "I");
        symbols.put(4, "IV");
        symbols.put(5, "V");
        symbols.put(9, "IX");
        symbols.put(10, "X");
        symbols.put(40, "XL");
        symbols.put(50, "L");
        symbols.put(90, "XC");
        symbols.put(100, "C");
        symbols.put(400, "CD");
        symbols.put(500, "D");
        symbols.put(900, "CM");
        symbols.put(1000, "M");

        return helper(num, symbols);
    }

    private static String helper(int num, Map<Integer, String> symbols) {
        if (symbols.containsKey(num)) {
            return symbols.get(num);
        }

        int closestNumber = getClosestKey(num, symbols);

        String left = helper(closestNumber, symbols);
        String right = helper(num - closestNumber, symbols);

        return left + right;
    }

    private static int getClosestKey(int num, Map<Integer, String> symbols) {
        int min = Integer.MAX_VALUE;
        int closest = 0;

        for (Integer key : symbols.keySet()) {
            int difference = num - key;
            if (difference >= 0 && difference < min) {
                min = difference;
                closest = key;
            }
        }


        return closest;
    }
}
