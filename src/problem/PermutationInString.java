package problem;

public class PermutationInString {
    public static void main(String[] args) {
        /*
        TODO: Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
         In other words, return true if one of s1's permutations is the substring of s2.
         */

        String s1 = "ab", s2 = "eidbaooo";
        //  String s1 = "ab", s2 = "eidboaoo";
        // String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];
        int s1Leng = s1.length();
        int s2Leng = s2.length();
        if (s1Leng > s2Leng) {
            return false;
        }

        for (int i = 0; i < s1Leng; i++) {
            char1[s1.charAt(i) - 'a']++;
            char2[s2.charAt(i) - 'a']++;
        }

        int maxSimilarity = 0;
        for (int i = 0; i < 26; i++) {
            if (char1[i] == char2[i]) maxSimilarity++;
        }

        int left = 0;
        for (int i = s1Leng; i < s2Leng; i++) {
            if (maxSimilarity == 26) return true;

            int index = s2.charAt(i) - 'a';
            char2[index]++;

            if (char2[index] == char1[index]) {
                maxSimilarity++;
            } else if (char1[index] + 1 == char2[index]) {
                maxSimilarity--;
            }

            int index2 = s2.charAt(left) - 'a';
            char2[index2]--;

            if (char2[index2] == char1[index2]) {
                maxSimilarity++;
            } else if (char1[index2] - 1 == char2[index2]) {
                maxSimilarity--;
            }
            left++;
        }


        return maxSimilarity == 26;
    }
}
