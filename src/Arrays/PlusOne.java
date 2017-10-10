package Arrays;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int digits[] = {9,9,9};

        Arrays.stream(plusOne(digits)).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length + 1];

        for (int i = result.length - 1; i >= 0; i--) {
            int sum;

            if (i - 1 >= 0) {
                sum = digits[i - 1] + carry;
            } else {
                sum = carry;
            }

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            result[i] = sum;
        }

        if (result[0] == 0) {
            int[] result2 = new int[digits.length];

            for (int i = 1; i <= result.length - 1; i++) {
                result2[i - 1] = result[i];
            }
            return result2;

        } else {
            return result;
        }
    }
}
