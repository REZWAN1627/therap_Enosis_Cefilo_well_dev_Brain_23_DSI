package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        /*
        TODO: Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
         find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
         and numbers[index2] where 1 <= index1 < index2 < numbers.length.Return the indices of the two numbers, index1
         and index2, added by one as an integer array [index1, index2] of length 2.
         The tests are generated such that there is exactly one solution. You may not use the same element twice.
         Your solution must use only constant extra space.
         */

        // int[] number = {2, 2, 7, 11, 15};
        //  int[] number = {-1, 0};
        int[] number = {12, 13, 23, 28, 43, 44, 59, 60, 61, 68,
                70, 86, 88, 92, 124, 125, 136, 168, 173, 173,
                180, 199, 212, 221, 227, 230, 277, 282, 306,
                314, 316, 321, 325, 328, 336, 337, 363, 365,
                368, 370, 370, 371, 375, 384, 387, 394, 400,
                404, 414, 422, 422, 427, 430, 435, 457, 493,
                506, 527, 531, 538, 541, 546, 568, 583, 585,
                587, 650, 652, 677, 691, 730, 737, 740, 751,
                755, 764, 778, 783, 785, 789, 794, 803, 809,
                815, 847, 858, 863, 863, 874, 887, 896, 916,
                920, 926, 927, 930, 933, 957, 981, 997};
        int[] ints = twoSum2(number, 542);
        // int[] ints = twoSum2(number, 9);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                if (!map.containsKey(target - numbers[i])) {
                    map.put(target - numbers[i], i);
                } else {
                    Integer index = map.get(target - numbers[i]);
                    if (numbers[i] + numbers[index] == target) {
                        ans[0] = index + 1;
                        ans[1] = i + 1;
                        return ans;
                    }
                }
            } else {
                Integer index = map.get(numbers[i]);
                if (numbers[i] + numbers[index] == target) {
                    ans[0] = index + 1;
                    ans[1] = i + 1;
                    return ans;
                }
            }

        }

        return ans;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
