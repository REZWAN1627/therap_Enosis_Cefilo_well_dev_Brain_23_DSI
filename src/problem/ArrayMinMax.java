package problem;

public class ArrayMinMax {
    public static void main(String[] args) {
        // int[] array = {3, 5, 4, 1, 9};
        int[] array = {22, 14, 8, 17, 35, 3};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                max = Math.max(max, Math.max(array[i], array[i + 1]));
                min = Math.min(min, Math.min(array[i], array[i + 1]));
            }
        }

        System.out.println("Min " + min + " max " + max);
    }
}
