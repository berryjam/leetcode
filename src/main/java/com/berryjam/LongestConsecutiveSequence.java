package com.berryjam;

// 重点复习回顾,HashSet空间换时间

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangjinkun.
 * @date 16/3/11
 * @time 下午3:36
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i : nums) {
            set.add(i);
        }

        int result = 0;
        int count = 0;


        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                count++;
                int pre = num - 1;
                set.remove(num);
                while (set.contains(pre)) {
                    count++;
                    set.remove(pre);
                    pre--;
                }

                int post = num + 1;
                while (set.contains(post)) {
                    count++;
                    set.remove(post);
                    post++;
                }

                result = Math.max(result, count);
            }
            count = 0;

        }

        return result;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        sequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        int a;
    }
}
