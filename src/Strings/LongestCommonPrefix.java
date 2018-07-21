package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"", ""};
        String[] strs2 = {"", "abc"};
        String[] strs3 = {"ab", "abc"};
        String[] strs4 = {"d", "abc"};
        String[] strs5 = {"  ", "       "};

//        System.out.println("".length());
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
        System.out.println(longestCommonPrefix(strs4));
        System.out.println(longestCommonPrefix(strs5).length());
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];

        if (prefix.isEmpty()) {
            return "";
        }

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            if (current.isEmpty()) {
                return "";
            }

            if (current.charAt(0) != prefix.charAt(0)) {
                prefix = "";
                break;
            }
            while (!current.startsWith(prefix) && prefix.length() > 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }


        return prefix;
    }
}
