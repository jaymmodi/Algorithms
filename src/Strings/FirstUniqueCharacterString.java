package Strings;

public class FirstUniqueCharacterString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("ee"));
        System.out.println(firstUniqChar("eeaabbcdddf"));
    }

    public static int firstUniqChar(String s) {
        int chars[] = new int[26];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (chars[c] == -1) {
                chars[c] = i;
            } else if (chars[c] >= 0) {
                chars[c] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 0) {
                if (chars[i] < min) {
                    min = chars[i];
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
