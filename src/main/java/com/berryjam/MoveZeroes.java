package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/27
 * @time 下午9:28
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums++;
            } else {
                nums[i - zeroNums] = nums[i];
            }
        }
        for (int i = nums.length - zeroNums; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
