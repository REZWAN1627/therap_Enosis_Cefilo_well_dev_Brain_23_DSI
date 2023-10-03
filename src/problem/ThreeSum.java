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
        int[] arr2 = {0, 0, 0, 0};
        int[] arr3 = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(arr));
        System.out.println(threeSum(arr2));
        System.out.println(threeSum(arr3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int k = nums.length - 1;
            int j = i + 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + target;
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(new ArrayList<>(List.of(nums[j], nums[k], target)));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

        }
        return ans;
    }
}
