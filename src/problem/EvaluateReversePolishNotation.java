package problem;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        /*
        TODO:You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
         Evaluate the expression. Return an integer that represents the value of the expression.
         Note that:
         The valid operators are '+', '-', '*', and '/'.
         Each operand may be an integer or another expression.
         The division between two integers always truncates toward zero.
         There will not be any division by zero.
         The input represents a valid arithmetic expression in a reverse polish notation.
         The answer and all the intermediate calculations can be represented in a 32-bit integer.
         */

    //    String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
     //   String[] arr = {"2","1","+","3","*"};
        String[] arr = {"4","13","5","/","+"};
        System.out.println(optimize(arr));
    }

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {

                String second = stack.pop();
                String first = stack.pop();
                int operatorA = Integer.parseInt(first);
                int operatorB = Integer.parseInt(second);

                switch (token) {
                    case "+" -> stack.push(String.valueOf(operatorA + operatorB));
                    case "-" -> stack.push(String.valueOf(operatorA - operatorB));
                    case "*" -> stack.push(String.valueOf(operatorA * operatorB));
                    default -> stack.push(String.valueOf(operatorA / operatorB));
                }

            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static int optimize(String[] tokens){
        Stack<Integer> st = new Stack<>();

        for(String x:tokens){


            if(x.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(b+a);

            }
            else if(x.equals("-")){
                int a =st.pop();
                int b = st.pop();
                st.push(b-a);
            }
            else if(x.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(b*a);
            }
            else if(x.equals("/")){
                int a = st.pop();
                int b =st.pop();
                st.push(b/a);

            }else

                st.push(Integer.parseInt(x));


        }
        return st.peek();
    }
}
