package Misc;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> sumOfSquares = new HashSet<>();

        while (sumOfSquares.add(n)) {
            int sum = 0;

            while (n > 0) {
                int lastDigit = n % 10;
                sum += lastDigit * lastDigit;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }

        }
        return false;
    }
}
