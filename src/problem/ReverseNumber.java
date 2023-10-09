package problem;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 1234;
        int reminder;
        int result = 0;
        while (n > 0) {
            reminder = n % 10;
            System.out.println(reminder);
            result = (result * 10) + reminder;
            n = n / 10;
        }

        System.out.println(result);

        long N = 345289467;
        System.out.print("Number of digits : "
                + countDigit(N));
    }

    static int countDigit(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }
}
