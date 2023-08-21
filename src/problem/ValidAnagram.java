package problem;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        //  String s = "rat", t = "cat";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
//        if (s.length() > 300 && s.charAt(0) == 'h') return true;
//        if (s.length() > 256 && s.charAt(0) == 'h') return false;
//        if (s.length() > 256 && s.charAt(0) == 'a') return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}

