package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/28
 * @time 上午10:01
 */
public class BulbSwitcher {

    public static final int OFF = 0;
    public static final int ON = 1;

//    public int bulbSwitch(int n) {
//        int[] bulbs = new int[n];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((j + 1) % i == 0) {
//                    bulbs[j] = (bulbs[j] == OFF) ? ON : OFF;
//                }
//            }
//        }
//
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            if (bulbs[i] == ON) {
//                result++;
//            }
//        }
//
//        return result;
//    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt((double) n);
    }

    public static void main(String[] args) {
        BulbSwitcher switcher = new BulbSwitcher();
        System.out.println(switcher.bulbSwitch(1000));
    }
}
