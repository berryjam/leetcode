package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/4
 * @time 下午3:35
 */
public class FindMiniumInRotatedSortedArray {


    public int findMin(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            result = Math.min(result, nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
