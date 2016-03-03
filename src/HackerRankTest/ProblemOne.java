package HackerRankTest;


import java.util.*;

public class ProblemOne {

    public static void main(String[] args) {
        String s = "abc";
        buildSubsets(s);
    }

    private static void buildSubsets(String s) {

        List<String> list = new ArrayList<String>();
        int start = 0;
        int end = s.length();

        while (end > 0) {
            while (start < s.length() - 1) {
                for (int i = start; i < end; i++) {
                    list.add(s.substring(i, end));
                }
                start++;
            }
            --end;
            start = 0;
        }
        Collections.sort(list);
        for (String s1 : list) {
            System.out.println("s1 = " + s1);
        }
    }
}
