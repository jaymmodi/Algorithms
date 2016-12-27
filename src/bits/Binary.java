package bits;

import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static void main(String[] args) {
        int a = 5;
//        int b = a ^ 5;

//        System.out.println(b);
        System.out.println(getBinary(a));
    }

    private static String getBinary(int number) {
        List<Integer> remainders = new ArrayList<>();

        while (number > 0) {
            int quotient = number / 2;
            int remainder = number % 2;

            if (remainder == 0) {
                remainders.add(0);
            } else {
                remainders.add(1);
            }

            number = quotient;
        }

        return getString(remainders);
    }

    private static String getString(List<Integer> remainders) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = remainders.size() - 1; i >= 0; i--) {
            stringBuilder.append(remainders.get(i));
        }

        return stringBuilder.toString();
    }
}
