package problem;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
       // String[] arr = {"ac","c"};
       // String[] arr = {"ac","d"};
        List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> listMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int key = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                key += strs[i].charAt(j);
            }
            if (listMap.containsKey(key)) {
                List<String> strings = listMap.get(key);
                strings.add(strs[i]);
            } else {
                listMap.put(key, new ArrayList<>(List.of(strs[i])));
            }
        }

        return new ArrayList<>(listMap.values());
    }
}
