package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("] ["));
    }

    public static boolean isValid(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        int position = 0;
        while (position != s.length()) {
            if (chars[position] == '(' || chars[position] == '{' || chars[position] == '[') {
                stack.push(chars[position]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if ((chars[position] == '}' && stack.peek() == '{') || (chars[position] == ']' && stack.peek() == '[') || (chars[position] == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            position++;
        }

        return stack.size() == 0;
    }
}

