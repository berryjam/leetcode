package com.berryjam;

/**
 * 重点复习，与MaximumSubarray类似，但是乘法性质不像加法一样，还需要维护一个最小的负数
 * http://blog.csdn.net/linhuanmars/article/details/39537283
 *
 * @author huangjinkun.
 * @date 16/4/4
 * @time 下午7:57
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxLocalCopy = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * nums[i], nums[i]), minLocal * nums[i]);
            minLocal = Math.min(Math.min(maxLocalCopy * nums[i], nums[i]), minLocal * nums[i]);
            global = Math.max(global, maxLocal);
        }

        return global;

    }

//    public int maxProduct(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return -1;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int maxProduct = dp[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i - 1] < 0) {
//                if (nums[i] < 0) {
//                    dp[i] = dp[i - 1] * nums[i];
//                } else if (nums[i] > 0) {
//                    dp[i] = nums[i];
//                } else {
//                    dp[i] = 0;
//                }
//            } else if (dp[i - 1] > 0) {
//                if (nums[i] > 0) {
//                    dp[i] = dp[i - 1] * nums[i];
//                } else if (nums[i] < 0) {
//                    dp[i] = nums[i];
//                } else {
//                    dp[i] = 0;
//                }
//            } else {
//                if (nums[i] > 0) {
//                    dp[i] = nums[i];
//                } else if (nums[i] < 0) {
//                    dp[i] = 0;
//                } else {
//                    dp[i] = 0;
//                }
//            }
//
//            maxProduct = Math.max(maxProduct, dp[i]);
//        }
//
//        return maxProduct;
//    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
//        System.out.println(maximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2, 3, -4}));
    }
}
