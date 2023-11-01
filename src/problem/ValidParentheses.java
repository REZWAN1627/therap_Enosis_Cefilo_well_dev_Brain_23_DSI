package problem;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        /*
        TODO Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
         string is valid.An input string is valid if:
         Open brackets must be closed by the same type of brackets.
         Open brackets must be closed in the correct order.
         Every close bracket has a corresponding open bracket of the same type.

         */

        String s = "([{}])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(')');
            } else if (s.charAt(i) == '{') {
                stack.add('}');
            } else if (s.charAt(i) == '[') {
                stack.add(']');
            } else {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    if (s.charAt(i) == ')') {
                        stack.add('(');
                    } else if (s.charAt(i) == '}') {
                        stack.add('{');
                    } else if (s.charAt(i) == ']') {
                        stack.add('[');
                    }
                }

            }

        }
        return stack.isEmpty();
    }
}
