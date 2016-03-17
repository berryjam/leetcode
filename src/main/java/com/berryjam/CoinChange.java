package com.berryjam;

import java.util.*;

// 超时，使用动态规划，重点复习 https://www.hrwhisper.me/leetcode-coin-change/

/**
 * @author huangjinkun.
 * @date 16/3/15
 * @time 下午12:54
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        final int INF = 0x7ffffffe;
        for (int i = 1; i <= amount; i++) dp[i] = INF;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

//    public int coinChange(int[] coins, int amount) {
//        Set<Integer> set = new HashSet<Integer>();
//        for (int i : coins) {
//            set.add(i);
//        }
//
//        List<Integer> list = new ArrayList<Integer>();
//        for (int i : set) {
//            list.add(i);
//        }
//        Collections.sort(list);
//
//        int count = 0;
//
//        return change(list, amount, count);
//    }

    public int change(List<Integer> coins, int amount, int count) {
        if (amount < coins.get(0)) {
            return -1;
        }

        if (coins.contains(amount)) {
            return count + 1;
        }

        int result = -1;
        for (int i : coins) {
            int tmpCount = count + 1;
            int tmp = change(coins, amount - i, tmpCount);
            if (tmp != -1) { // 有解
                if (result == -1) {
                    result = tmp;
                } else {
                    result = Math.min(result, tmp);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        System.out.println(change.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(change.coinChange(new int[]{2}, 3));
        System.out.println(change.coinChange(new int[]{3, 7, 8, 11}, 63));
    }
}
