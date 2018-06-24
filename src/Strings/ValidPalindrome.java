package Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome("bbb"));
//        System.out.println(isPalindrome("aba"));
//        System.out.println(isPalindrome("malayalam"));
//        System.out.println(isPalindrome(".,"));
//        System.out.println(isPalindrome(".ba,"));
//        System.out.println(isPalindrome(".bb,"));
//        System.out.println(isPalindrome(".bbb,"));
//        System.out.println(isPalindrome(".b.b,"));
//        System.out.println(isPalindrome(".b.a,"));
//        System.out.println(isPalindrome("0b"));
//        System.out.println(isPalindrome("00"));
//        System.out.println(isPalindrome("0"));
//        System.out.println(isPalindrome("01"));
//        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(".G?j!:;;:Gj?!."));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            while (!(isValidCharacter(startChar) || isValidNumber(startChar)) && start < end) {
                start++;
                startChar = s.charAt(start);
            }

            while (!(isValidCharacter(endChar) || isValidNumber(endChar)) && start < end) {
                end--;
                endChar = s.charAt(end);
            }

            int diff = startChar - endChar;

            if (start < end) {
                if (isValidCharacter(startChar) && isValidCharacter(endChar)) {
                    if ((diff < -32) || (diff > -32 && diff < 0) || (diff > 0 && diff < 32) || (diff > 32)) {
                        return false;
                    }

                } else if (isValidNumber(startChar) && isValidNumber(endChar)) {
                    if (diff != 0) {
                        return false;
                    }
                } else if ((isValidCharacter(startChar) && isValidNumber(endChar)) || (isValidNumber(startChar) && isValidCharacter(endChar))) {
                    return false;
                }
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isValidCharacter(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }

    private static boolean isValidNumber(char character) {
        return (character >= '0' && character <= '9');
    }
}
