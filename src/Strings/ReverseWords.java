package Strings;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }


    public static String reverseWords(String s) {
        String[] split = s.split(" ");

        StringBuilder ans = new StringBuilder();
        for (String s1 : split) {
            ans.append(reverseString(s1)).append(" ");
        }

        return ans.toString().trim();
    }


    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            return "";
        }

        int mid = s.length() / 2;
        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < mid) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            ++left;
            --right;
        }

        return String.valueOf(chars);
    }
}
