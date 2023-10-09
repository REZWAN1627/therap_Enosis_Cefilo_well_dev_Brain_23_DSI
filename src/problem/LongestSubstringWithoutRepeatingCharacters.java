package problem;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();
        int max = 0;
        Set<Character> characters = new HashSet<>(length);
        while (right < length) {
            if (characters.add(s.charAt(right))) {
                right++;
                max = Math.max(characters.size(), max);
            } else {
                characters.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
