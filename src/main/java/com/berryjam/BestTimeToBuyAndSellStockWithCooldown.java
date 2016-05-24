package com.berryjam;

/**
 * 比较难的DP题，DP题目
 * 1.找出能够表示状态的变量
 * 2.推导出状态转移方程
 * <p>
 * solution:https://leetcode.com/discuss/71354/share-my-thinking-process
 * <p>
 * buy[i] = max(sell[i-2]-price, buy[i-1])
 * sell[i] = max(buy[i-1]+price, sell[i-1])
 * <p>
 * buy[i] means before day i what is the maxProfit for any sequence end with buy.
 * sell[i] means before day i what is the maxProfit for any sequence end with sell.
 * Where price is the price of day i.
 *
 * @author huangjinkun.
 * @date 16/5/24
 * @time 上午12:13
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
