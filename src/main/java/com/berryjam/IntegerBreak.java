package com.berryjam;

/**
 * fuxi
 *
 * @author huangjinkun.
 * @date 16/5/11
 * @time 下午12:04
 */
public class IntegerBreak {

    public int intgerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (i + j <= n) {
                    dp[i + j] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak app = new IntegerBreak();
        System.out.println(app.intgerBreak(10));
    }
}
