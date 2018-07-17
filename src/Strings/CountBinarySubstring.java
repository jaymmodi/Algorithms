package Strings;

public class CountBinarySubstring {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("1010"));
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("000111"));
        System.out.println(countBinarySubstrings("0001111"));
        System.out.println(countBinarySubstrings("01"));
        System.out.println(countBinarySubstrings("0"));
        System.out.println(countBinarySubstrings("1"));
        System.out.println(countBinarySubstrings("00"));
        System.out.println(countBinarySubstrings("11"));
        System.out.println(countBinarySubstrings("000000100000110"));
        System.out.println(countBinarySubstrings("0010"));
        System.out.println(countBinarySubstrings("10010011"));
        System.out.println(countBinarySubstrings("110111111111101010010011110"));
        System.out.println(countBinarySubstrings("0011111100"));
    }

    public static int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int count = 0;
        int numberOfOnes = 0;
        int numberOfZeros = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '0') {
                if (numberOfOnes > 0) {
                    count++;
                    if (i + 1 < chars.length && chars[i + 1] == '1') {
                        numberOfOnes = 0;
                    } else {
                        numberOfOnes--;
                    }
                }
                numberOfZeros++;
            } else {
                if (numberOfZeros > 0) {
                    count++;
                    if (i + 1 < chars.length && chars[i + 1] == '0') {
                        numberOfZeros = 0;
                    } else {
                        numberOfZeros--;
                    }
                }
                numberOfOnes++;
            }
        }


        return count;
    }
}
