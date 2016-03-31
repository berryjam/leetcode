package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/31
 * @time 下午8:52
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int index = 0;
        int curGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += (gas[i] - cost[i]);
            if (curGas < 0) {
                index = i + 1;
                curGas = 0;
            }
        }
        if (curGas >= 0) {
            return index;
        } else {
            return -1;
        }
    }
}
