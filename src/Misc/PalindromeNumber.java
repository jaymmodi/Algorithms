package Misc;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-50));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x / 10 == 0 && x >= 10)) {
            return false;
        }

        return x == reverse(x);
    }

    private static int reverse(int x) {
        int rev = 0;

        while (x / 10 != 0) {
            int unitPlace = x % 10;
            rev = rev * 10 + unitPlace;
            x = x / 10;
        }
        return rev * 10 + x;
    }

}
