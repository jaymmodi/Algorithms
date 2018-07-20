package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < strs[0].length() && j < strs[1].length()) {
            if (strs[0].charAt(i) == strs[j].charAt(j)) {
                sb.append(strs[0].charAt(i));
            }
            i++;
            j++;
        }

        for


        return sb.toString();
    }
}
