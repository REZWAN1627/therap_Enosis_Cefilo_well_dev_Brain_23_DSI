package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

        /*
        TODO: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j,
         i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.Notice that the solution set must
         not contain duplicate triplets.
         */

        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr2 = {0,0,0,0};
        int[] arr3 = {-1,-1,-1,2};
        System.out.println(threeSum(arr));
        System.out.println(threeSum(arr2));
        System.out.println(threeSum(arr3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            int target = nums[k];

            int j = nums.length - 1;
            int i = k + 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + target;
                if (sum == 0) {
                    ans.add(new ArrayList<>(List.of(nums[i],nums[j],target)));
                    break;
                }
                if (sum > 0) {
                    j--;
                }
                if (sum < 0) {
                    i++;
                }
            }

        }
        return ans;
    }
}
