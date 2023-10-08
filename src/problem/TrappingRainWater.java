package problem;

public class TrappingRainWater {
    public static void main(String[] args) {
        /*
        TODO: Given n non-negative integers representing an elevation map where the width of each bar is 1,
         compute how much water it can trap after raining.
         */

        int[] trapArr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(trapArr));

    }

    public static int trap(int[] height) {

        int i = 0;
        int j = height.length - 1;

        int left = height[0];
        int right = height[j];

        int totalWater = 0;


        while (i < j) {
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }

            int leftWater = left - height[i];
            if (leftWater > 0) {
                totalWater += leftWater;
            }
            if (height[i] > left) {
                left = height[i];
            }
            int rightWater = right - height[j];
            if (rightWater > 0) {
                totalWater += rightWater;
            }
            if (height[j] > right) {
                right = height[j];
            }
        }

        return totalWater;
    }
}
