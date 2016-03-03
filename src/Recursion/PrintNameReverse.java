package Recursion;

public class PrintNameReverse {

    public static void main(String[] args) {
        String s = "c";
        System.out.println("s = " + s);

        String substring = s.substring(1);
        System.out.println("substring = " + substring);
        System.out.println("s = " + s);

        printReverse("Jay");
        System.out.println(reverseString("JayModi"));
    }

    private static void printReverse(String name) {
        char[] nameArray = name.toCharArray();
        print(nameArray, 1, nameArray.length);
    }

    private static int print(char[] nameArray, int start, int end) {
        if (start == end) {
            System.out.println(nameArray[start - 1]);
            return end;
        } else {
            end = print(nameArray, ++start, end);
            return print(nameArray, --start, --end);
        }
    }

    public static String reverseString(String s) {
        if (s.length() == 0)
            return s;

        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
