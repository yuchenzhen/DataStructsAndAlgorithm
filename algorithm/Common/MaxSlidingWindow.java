import java.util.Map;

public class MaxSlidingWindow {
    public int[] Solution (int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) return new int[0];
        if (k == 1) {
            return nums;
        }

        int[] left = new int[len];              // 表示从左到右， 块开始的地方到 i 位置，最大的数
        int[] right = new int[len];             // 表示从右到左， 块开始的地方到 i 位置，最大的数
        left[0] = nums[0];
        right[len-1] = nums[len-1];

        for (int i = 1; i < len; i++) {
            if ( i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }

            int j = len - i - 1;
            if (j % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }

        int[] output = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            output[i] = Math.max(right[i], left[i + k -1]);
        }
        return output;
    }
}
