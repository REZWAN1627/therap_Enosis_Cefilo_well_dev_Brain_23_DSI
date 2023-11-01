package problem;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        /*
        TODO:You are given a string s and an integer k. You can choose any character of the string and change it to any
         other uppercase English character. You can perform this operation at most k times.Return the length of the
         longest substring containing the same letter you can get after performing the above operations.
         */

        //TODO: need to do again

        String s = "AABABBA";
      //  String s = "ABAB";
         int k = 1;
       // int k = 2;
        System.out.println(characterReplacement(s, k));

    }

    public static int characterReplacement(String s, int k) {
        int max_length = 0;
        int len = s.length();
        int start = 0;
        int[] charr = new int[26];
        int max_count = 0;
        for (int right = 0; right < len; right++) {
            charr[s.charAt(right) - 'A']++;
            int current_char_count = charr[s.charAt(right) - 'A'];
            max_count = Math.max(max_count, current_char_count);
            while (right - start - max_count + 1 > k) {
                charr[s.charAt(start) - 'A']--;
                start++;
            }

            max_length = Math.max(max_length, right - start + 1);
        }
        return max_length;
    }
}
