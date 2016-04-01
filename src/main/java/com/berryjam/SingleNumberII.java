package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/4/1
 * @time 上午11:28
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 4) {
            return nums[0];
        }

        int[] bits = new int[32];

        int all = 0xffffffff;

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] & all;
            for (int j = 0; j < bits.length; j++) {
                int curBit = 1;
                for (int k = 0; k < j; k++) {
                    curBit *= 2;
                }
                int bit = tmp & curBit;
                if (bit != 0) {
                    bits[j]++;
                    bits[j] %= 3;
                }
            }
        }

        return binary2Decimal(bits);
    }

    private int binary2Decimal(int[] bits) {
        int result = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            result = 2 * result + bits[i];
        }

        return result;
    }


    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        System.out.println(singleNumberII.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
