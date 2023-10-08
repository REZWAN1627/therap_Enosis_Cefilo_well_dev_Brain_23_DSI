package problem;

public class BestTimeBuyAndSellStock {
    public static void main(String[] args) {
        /*
        TODO:You are given an array prices where prices[i] is the price of a given stock on the ith day.
         You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
         Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
         */
        int[] arr = {7, 1, 5, 3, 6, 4};
        //int [] arr = {2,1,4};
        //int [] arr = {7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = i + 1;
        int max = 0;
        int length = prices.length;
        while (j < length) {
            if (prices[i] < prices[j]) {
                max = Math.max(max, prices[j] - prices[i]);

            } else {
                i = j;
            }
            j++;
        }
        return max;

    }
}
