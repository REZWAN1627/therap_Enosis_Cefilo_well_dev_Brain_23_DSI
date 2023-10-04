package problem;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        /*
        TODO: You are given an integer array height of length n. There are n vertical lines drawn such that the two
         endpoints of the ith line are (i, 0) and (i, height[i]).Find two lines that together with the x-axis form a
         container, such that the container contains the most water.
         Return the maximum amount of water a container can store.
         Notice that you may not slant the container.
         */
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr2 = {1, 1};
        int[] arr3 = {2, 4, 3, 8, 5, 4};
        System.out.println(maxArea2(arr));
        System.out.println(maxArea2(arr2));
        System.out.println(maxArea2(arr3));
    }


    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int stableHeight;
                if (height[i] > height[j]) {
                    stableHeight = height[j];
                } else if (height[i] < height[j]) {
                    stableHeight = height[i];
                } else {
                    stableHeight = height[j];
                }
                int tempArea = stableHeight * (j - i);
                if (tempArea > area) {
                    area = tempArea;
                }
            }
        }
        return area;
    }

    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int tempMaxArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, tempMaxArea);
            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
