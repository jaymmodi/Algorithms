package Strings;

public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("Hello1"));
        System.out.println(toLowerCase("!2342"));
    }

    public static String toLowerCase(String str) {
        if (str.trim().isEmpty()) {
            return str;
        }

        int difference = 'a' - 'A';
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) ((int) chars[i] + difference);
            }
        }

        return new String(chars);
    }
}
