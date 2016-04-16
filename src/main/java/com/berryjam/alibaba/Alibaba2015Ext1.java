package com.berryjam.alibaba;

/**
 * @author huangjinkun.
 * @date 16/4/14
 * @time 下午10:21
 */
public class Alibaba2015Ext1 {

    public int longestCommonSubstring(String text, String query) {
        int[][] dp = new int[text.length()][query.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return getLongestCommonSubstring(text, query, text.length() - 1, query.length() - 1, dp);
    }

    public int getLongestCommonSubstring(String text, String query, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == 0 || j == 0) {
            return 0;
        }

        if (text.charAt(i) == query.charAt(j)) {
            dp[i][j] = getLongestCommonSubstring(text, query, i - 1, j - 1, dp) + 1;
        } else {
            dp[i][j] = Math.max(getLongestCommonSubstring(text, query, i - 1, j, dp), getLongestCommonSubstring(text,
                    query, i, j - 1, dp));
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        Alibaba2015Ext1 app = new Alibaba2015Ext1();
        System.out.println(app.longestCommonSubstring("acaccbabb", "acbac"));
    }
}
