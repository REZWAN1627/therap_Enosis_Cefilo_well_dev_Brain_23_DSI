package problem;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
       /*
       You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
       of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
       right by one position.Return the max sliding window.
        */

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        //  int k = 3;

        //  int[] arr = {1};
        //   int k = 1;

        //int[] arr = {1,3,1,2,0,5};
        int k = 3;


        System.out.println(Arrays.toString(maxSlidingWindow3(arr, k)));


    }

    //TODO: Time Limit Exceeded
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int i = 0;
        List<Integer> max = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int j = 0; j < nums.length; j++) {
            priorityQueue.add(nums[j]);
            if (j + 1 - i == k) {
                Integer poll = priorityQueue.peek();
                max.add(poll);
                priorityQueue.remove(nums[i]);
                i++;
            }


        }
        int[] ans = new int[max.size()];
        for (int j = 0; j < max.size(); j++) {
            ans[j] = max.get(j);
        }
        return ans;
    }

    //TODO: Time Limit Exceeded
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        if (k == 1) {
            return nums;
        }
        int i = 0;
        List<Integer> integers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 - i == k) {
                int max = Integer.MIN_VALUE;
                for (int l = i; l < j + 1; l++) {
                    max = Math.max(max, nums[l]);
                }
                integers.add(max);
                i++;
            }
        }
        int[] ans = new int[integers.size()];
        for (int j = 0; j < integers.size(); j++) {
            ans[j] = integers.get(j);
        }
        return ans;

    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        if (k == 1) {
            return nums;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        int[] ans = new int[nums.length - k +1];
        int max_index = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (!deque.isEmpty() && nums[j] <= nums[deque.getLast()]) {
                deque.add(j);
            } else {
                while (!deque.isEmpty() && nums[j] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.add(j);
            }

            if (j + 1 - i == k) {
                Integer first = deque.getFirst();
                ans[max_index] = nums[first];
                i++;
                max_index++;
                if (i > first) {
                    deque.remove(first);
                }

            }

        }
        return ans;
    }
}
