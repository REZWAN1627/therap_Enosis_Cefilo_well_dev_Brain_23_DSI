package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    static Stack<String> stack = new Stack<>();
    static List<String> strings = new ArrayList<>();
    static int N = 0;

    public static void main(String[] args) {
        /*
        TODO: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses
         */
        int n = 3;
        System.out.println(generateParenthesis(n));

    }

    public static List<String> generateParenthesis(int n) {
        N = n;
        backtrack(0, 0);
        List<String> strings = new ArrayList<>();
        generateParenthesisRecurse(strings,"",0,0,n);
        return strings;
    }

    private static void backtrack(int open, int close) {
        if (open == N && close == N) {
            StringBuilder builder = new StringBuilder();
            stack.forEach(builder::append);
            strings.add(builder.toString());
            return;
        }
        if (open < N) {
            stack.add("(");
            backtrack(open + 1, close);
            stack.pop();
        }

        if (close < open) {
            stack.add(")");
            backtrack(open, close + 1);
            stack.pop();
        }
    }

    public static void generateParenthesisRecurse(List<String> results, String string, int open, int closed, int n) {
        // All pairs done
        if (closed == n) {
            results.add(string);
        } else {
            // Recurse with new pair
            if (open < n) {
                generateParenthesisRecurse(results, string + "(", open + 1, closed, n);
            }
            // Recurse with closing
            if (closed < open) {
                generateParenthesisRecurse(results, string + ")", open, closed + 1, n);
            }
        }
    }
}
