package problem;

public class KthSmallestElement {
    public static void main(String[] args) {

        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int i = kthSmallest(array, 0, array.length - 1, 4);
        System.out.println(i);

    }

    public static int kthSmallest(int[] nums, int l, int r, int k) {

        int[] frequence = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            frequence[nums[i]]++;
        }
        int kth = 0;
        for (int i = frequence.length - 1; i >= 0; i--) {
            kth = kth + frequence[i];
            if (kth >= k) {
                return i;
            }
        }

        return -1;
    }
}
