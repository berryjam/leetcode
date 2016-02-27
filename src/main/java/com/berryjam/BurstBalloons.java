package com.berryjam;

import java.util.Arrays;

/**
 * @author huangjinkun.
 * @date 16/2/27
 * @time 下午2:19
 */
public class BurstBalloons {

    private int dp(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], dp(i, x - 1, nums, dp) + nums[i - 1] * nums[x] * nums[j + 1] + dp(x +
                            1, j,
                    nums, dp));
        }
        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] tmpNums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            tmpNums[i + 1] = nums[i];
        }
        tmpNums[0] = tmpNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return dp(1, n, tmpNums, dp);
    }

//    public int maxCoins(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        } else {
//            int max = 0;
//            for (int i = 0; i < nums.length; i++) {
//                int left = 0, right = 0, self = 0, other = 0;
//                if (i == 0) {
//                    left = 0;
//                    self = nums[i] * nums[i + 1];
//                    right = maxCoins(Arrays.copyOfRange(nums, i + 1, nums.length));
//                    other = 0;
//                } else if (i == nums.length - 1) {
//                    left = maxCoins(Arrays.copyOfRange(nums, 0, nums.length - 1));
//                    self = nums[i - 1] * nums[i];
//                    right = 0;
//                    other = 0;
//                } else {
//                    left = 0;
//                    self = nums[i - 1] * nums[i] * nums[i + 1];
//                    right = 0;
//                    int[] tmpArray = getExceptSelfArray(nums,i);
//                    other = maxCoins(tmpArray);
//                }
//
//                int tmp = left + right + self + other;
//                if (tmp > max) {
//                    max = tmp;
//                }
//            }
//            return max;
//        }
//    }

    private int[] getExceptSelfArray(int[] nums, int i) {
        int[] tmpArray = new int[nums.length - 1];
        for (int j = 0, k = 0; j < tmpArray.length && k < nums.length; ) {
            if (j < i) {
                tmpArray[j++] = nums[k++];
            } else if (j == i) {
                tmpArray[j++] = nums[k + 1];
                k += 2;
            } else {
                tmpArray[j++] = nums[k++];
            }
        }
        return tmpArray;
    }

    public static void main(String[] args) {
        BurstBalloons balloons = new BurstBalloons();
//        System.out.println(balloons.maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(balloons.maxCoins(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3}));
    }
}
