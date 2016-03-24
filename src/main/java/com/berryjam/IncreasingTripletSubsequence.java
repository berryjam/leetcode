package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/24
 * @time 上午11:25
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        Integer first = nums[0];
        Integer second = null;
        for (int i = 1; i < nums.length; i++) {
            if (second == null) {
                if (nums[i] > first) {
                    second = nums[i];
                } else if (nums[i] < first) {
                    first = nums[i];
                }
            } else {
                if (nums[i] > second) {
                    return true;
                } else if (nums[i] < second) {
                    if (nums[i] > first) {
                        second = nums[i];
                    } else if (nums[i] < first) {
                        first = nums[i];
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence subsequence = new IncreasingTripletSubsequence();
        System.out.println(subsequence.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(subsequence.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }
}
