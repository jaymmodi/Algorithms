package Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeString {

    public static void main(String[] args) {
        String encodedString = "2[abc]3[cd]ef";

        System.out.println(decodeString(encodedString));
    }

    public static String decodeString(String s) {
        char openBracket = '[';

        String regex = "(\\d+)\\[([a-zA-Z]+)\\]";
        Pattern pattern = Pattern.compile(regex);
        String decodedString = s;

        while (decodedString.contains(String.valueOf(openBracket))) {
            Matcher matcher = pattern.matcher(decodedString);

            if (matcher.find()) {
                String decodeSubstring = decodePerfectString(Integer.valueOf(matcher.group(1)), matcher.group(2));
                decodedString = decodedString.replaceFirst(regex, decodeSubstring);
            }
        }

        return decodedString;
    }

    private static String decodePerfectString(int number, String perfectSubstring) {
        return IntStream.rangeClosed(1, number).mapToObj(i -> perfectSubstring).collect(Collectors.joining());
    }
}
