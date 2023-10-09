package problem;

public class ValidPalindrome {
    public static void main(String[] args) {
        //eye
        //annnna
        boolean amanaplanacanalpanama = isPalindrome("anopna");
        System.out.println(amanaplanacanalpanama);
    }

    //amanaplanac analpanama
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}

