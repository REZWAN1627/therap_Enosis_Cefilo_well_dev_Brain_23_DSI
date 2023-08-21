package problem;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1};
        boolean b = containsDuplicate(array);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            boolean flag = integers.add(num);
            if (!flag){
                return true;
            }
        }
        return false;
    }
}
