package Recursion.Backtracking;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        return Stream.of(s.split("")).sorted().collect(Collectors.joining()).equals(Stream.of(t.split("")).sorted().collect(Collectors.joining()));
    }
}
