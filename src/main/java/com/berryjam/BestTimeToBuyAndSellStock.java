package com.berryjam;

// 重点复习 动态规划

/**
 * @author huangjinkun.
 * @date 16/3/2
 * @time 下午2:49
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int curMin = prices[0];

        for(int i=0;i<prices.length;i++){
            curMin = Math.min(curMin,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-curMin);
        }

        return maxProfit;
    }


    public static void main(String[] args) {

    }
}
