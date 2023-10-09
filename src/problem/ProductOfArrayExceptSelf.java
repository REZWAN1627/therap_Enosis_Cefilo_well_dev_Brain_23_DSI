package problem;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //TODO: 238. Product of Array Except Self

        /*
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
        elements of nums except nums[i].The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        You must write an algorithm that runs in O(n) time and without using the division operation.
         */

        int[] arr = {1, 2, 3, 4};
        // int[] arr = {4, 3, 2, 1, 2};
        int[] ans = productExceptSelf(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        int j = nums.length - 2;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[j] = right[j + 1] * nums[j + 1];
            j--;
        }

        System.out.println(Arrays.toString(left) + " & " + Arrays.toString(right));

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    /* optimized
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int r = 1;
        for (int j = len - 1; j >= 0; j--) {
            res[j] = res[j] * r;
            r *= nums[j];
        }
        return res;
    }
     */
}
