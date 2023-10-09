package problem;

import java.util.*;

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
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int k = nums.length - 1;
            int j = i + 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(new ArrayList<>(List.of(nums[j], nums[k], nums[i])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int l, r, sum;
        Set<List<Integer>> tempRes = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
                if (sum < 0) ++l;
                else --r;
            }
        }
        return new ArrayList<>(tempRes);
    }
}
