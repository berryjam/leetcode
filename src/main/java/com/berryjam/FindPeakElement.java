package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/4/17
 * @time 下午10:47
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

}
