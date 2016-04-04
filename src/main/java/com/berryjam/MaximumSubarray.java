package com.berryjam;

/**
 * 使用分治法要注意二分时的边界，求跨前后两端的情况，从中间分别向两端扩展；
 * 使用动态规划要先给出状态转移方程，注意b[j]含义：http://blog.csdn.net/liufeng_king/article/details/8632430
 *
 * @author huangjinkun.
 * @date 16/4/4
 * @time 上午11:12
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length <= 0) {
//            return -1;
//        }
//
//        int l = 0, r = nums.length - 1;
//        return maxSubArray(nums, l, r);
//    }

    private int maxSubArray(int[] nums, int l, int r) {
        int sum = 0;
        if (l == r) {
            return nums[l];
        } else {
            int mid = (l + r) / 2;

            int left = maxSubArray(nums, l, mid);
            int right = maxSubArray(nums, mid + 1, r);

            int ls = nums[mid], lefts = 0;
            for (int i = mid; i >= l; i--) {
                lefts += nums[i];
                ls = Math.max(ls, lefts);
            }

            int rs = 0, rights = 0;
            for (int j = mid + 1; j <= r; j++) {
                rights += nums[j];
                rs = Math.max(rs, rights);
            }

            sum = ls + rs; // sum保存跨前后两段情况的最大子段和

            sum = Math.max(left, Math.max(sum, right));
        }


        return sum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, -1}));
    }
}
