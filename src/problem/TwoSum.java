package problem;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] array, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result[0] = map.get(target - array[i]);
                result[1] = i;
                break;
            }
            map.put(array[i], i);
        }
        return result;
    }
}