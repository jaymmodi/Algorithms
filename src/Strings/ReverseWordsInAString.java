package Strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords("  "));
        System.out.println(reverseWords("a  "));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(" 1"));
        System.out.println(reverseWords("   a   b "));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) {
            return "";
        }

        int start = 0;
        int end = split.length - 1;

        while (start < end) {
            while (split[start].equals("")) {
                start++;
            }

            while (split[end].equals("")) {
                end--;
            }

            if (start < end) {
                String temp = split[start];
                split[start] = split[end];
                split[end] = temp;

                start++;
                end--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("")) {
                result.append(split[i]);
                if (i < split.length - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }
}
