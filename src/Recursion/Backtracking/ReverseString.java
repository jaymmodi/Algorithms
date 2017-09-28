package Recursion.Backtracking;

public class ReverseString {

    public static void main(String[] args) {
        String str = "jay \n modi";

        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        if (str == null) {
            return null;
        }

        if (str.isEmpty()) {
            return "";
        }

        return reverseString(str, 0);
    }

    private static String reverseString(String str, int index) {
        if (index == str.length() - 1) {
            return str.substring(str.length() - 1, str.length());
        }

        return reverseString(str, index + 1) + str.substring(index, index + 1);
    }

}
