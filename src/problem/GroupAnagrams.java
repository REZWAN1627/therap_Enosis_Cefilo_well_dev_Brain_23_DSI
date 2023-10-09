package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        //   String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] arr = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        // String[] arr = {"ac","c"};
        // String[] arr = {"ac","d"};
        List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] position = new char[26];
            for (int j = 0; j < strs[i].length(); j++) {
                position[strs[i].charAt(j) - 'a']++;
            }
            String key = new String(position);
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
