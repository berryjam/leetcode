package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/31
 * @time 下午10:56
 */
public class SortColors {
    public static final int RED = 0;
    public static final int WHItE = 1;
    public static final int BLUE = 2;

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int redNums = 0;
        int whiteNums = 0;
        int blueNums = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case RED:
                    redNums++;
                    break;
                case WHItE:
                    whiteNums++;
                    break;
                case BLUE:
                    blueNums++;
                    break;
            }
        }

        for (int i = 0; i < redNums; i++) {
            nums[i] = RED;
        }

        for (int i = redNums; i < redNums + whiteNums; i++) {
            nums[i] = WHItE;
        }

        for (int i = redNums + whiteNums; i < nums.length; i++) {
            nums[i] = BLUE;
        }
    }
}
