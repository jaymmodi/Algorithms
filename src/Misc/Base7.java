package Misc;

public class Base7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(8));
        System.out.println(convertToBase7(7));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(-6));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-8));
    }

    public static String convertToBase7(int num) {
        if (num > -7 && num < 7) {
            return "" + num;
        }

        boolean isNegative = false;
        if (num < 0) {
            num = -1 * num;
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int quotient = num / 7;
            int remainder = num % 7;

            sb.append(remainder);
            num = quotient;
        }

        String result = sb.reverse().toString();
        return isNegative ? "-" + result : result;
    }
}
