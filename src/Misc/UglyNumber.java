package Misc;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(1332185066));

    }

    public static boolean isUgly(int num) {
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        }

        if (num <= 0) {
            return false;
        }

        for (int i = 2; i < 6; i++) {
            while (num % 2 == 0) {
                num = num / i;
            }
        }

        return num == 1;
    }
}
