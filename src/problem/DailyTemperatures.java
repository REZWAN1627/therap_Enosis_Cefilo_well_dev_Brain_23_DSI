package problem;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

        /*
        TODO: Given an array of integers temperatures represents the daily temperatures, return an array answer such
         that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there
         is no future day for which this is possible, keep answer[i] == 0 instead.
         */

       // int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            Integer peekIndex = stack.peek();
            int right = temperatures[i];
            int left = temperatures[i - 1];
            if (right > left) {
                ans[i - 1] = i - peekIndex;
                stack.pop();
                while (!stack.isEmpty() && temperatures[stack.peek()] < right) {
                    Integer popRecentIndex = stack.pop();
                    ans[popRecentIndex] = i - popRecentIndex;
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        return ans;
    }
}
