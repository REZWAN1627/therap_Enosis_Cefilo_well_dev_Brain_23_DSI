package problem;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        //TODO: Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

        // int[] arr = {1, 1, 1, 2, 2, 3};
        // int[] arr = {1};
        // int[] arr = {-1, -1};
       // int[] arr = {1, 2};
        int[] arr = {3, 0, 1, 0};
        int k = 1;
        //int k = 2;
        int[] ints = topKFrequent(arr, k);
        System.out.println(Arrays.toString(ints));


    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        if (nums.length == 1) {
            ans[0] = nums[nums.length - 1];
        }
        Map<Integer, Integer> frequent = new HashMap<>(nums.length);

        for (int num : nums) {
            if (frequent.containsKey(num)) {
                Integer i1 = frequent.get(num);
                frequent.put(num, i1 + 1);
            } else {
                frequent.put(num, 1);
            }
        }
        Map<Integer, List<Integer>> temp = new HashMap<>(nums.length);
        frequent.forEach((key, val) -> {
            if (temp.containsKey(val)) {
                List<Integer> integers = temp.get(val);
                integers.add(key);
            } else {
                temp.put(val, new ArrayList<>(List.of(key)));
            }
        });
        System.out.println(temp);
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (j >= k) {
                break;
            }
            if (temp.containsKey(i)) {
                List<Integer> integers = temp.get(i);
                for (Integer integer : integers) {
                    if (j >= k) {
                        break;
                    }
                    ans[j] = integer;
                    j++;
                }
            }
        }

        return ans;
    }
}
