package problem;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        // char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));

    }

    private static void reverseString(char[] s) {
        int j = s.length - 1;

        for (int i = 0; i <= (s.length - 1) / 2; i++) {
            var temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}
