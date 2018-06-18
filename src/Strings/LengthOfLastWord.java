package Strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord("  "));
        System.out.println(lengthOfLastWord("Hello s"));
        System.out.println(lengthOfLastWord("Hello"));
        System.out.println(lengthOfLastWord("Hello "));
        System.out.println(lengthOfLastWord(" Hello"));
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        s = s.trim();
        if (s.length() == 1) {
            return 1;
        }

        int index = s.lastIndexOf(" ");
        if (index == -1) {
            return s.length();
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }
        }

        return 0;
    }

}
