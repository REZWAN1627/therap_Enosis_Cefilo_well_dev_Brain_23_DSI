package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        /*
        TODO:Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
         You must write an algorithm that runs in O(n) time.
         */

        //int[] nums = {100, 4, 200, 1, 3, 2};
        //  int[] nums = {0,3,7,2,5,8,4,6,0,1};
        // int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        //  int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1, 2, 0, 1};
        int i = longestConsecutive(nums);
        System.out.println("Actual " + i);
        int i1 = longestConsecutive2(nums);
        System.out.println(i1);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int ans = 1;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (nums[i] + 1 == nums[i + 1]) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }

        }
        return Math.max(ans, count);
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> integers = new HashSet<>(nums.length);
        for (int j : nums) {
            integers.add(j);
        }
        int longest = 0;
        for (int num : nums) {
            int current_num = num;
            int current_sequence = 1;

            if (!integers.contains(current_num - 1)) {
                while (integers.contains(current_num + 1)) {
                    current_num += 1;
                    current_sequence += 1;
                }

                longest = Math.max(longest, current_sequence);
            }

        }

        return longest;

    }

}
