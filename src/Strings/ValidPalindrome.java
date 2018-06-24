package Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("bbb"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("malayalam"));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome(".ba,"));
        System.out.println(isPalindrome(".bb,"));
        System.out.println(isPalindrome(".bbb,"));
        System.out.println(isPalindrome(".b.b,"));
        System.out.println(isPalindrome(".b.a,"));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (!isValidCharacter(s.charAt(start)) && start < end) {
                start++;
            }

            while (!isValidCharacter(s.charAt(end)) && start < end) {
                end--;
            }

            if (start < end && s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isValidCharacter(char character) {
        return (character >= 'a' && character <= 'z') || (character >= '0' && character <= '9');
    }
}
