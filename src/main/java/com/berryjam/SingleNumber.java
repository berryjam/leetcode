package com.berryjam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午1:56
 */
public class SingleNumber {

//    public int singleNumber(int[] nums) {
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
//        }
//        for (int i : map.keySet()) {
//            if (map.get(i) == 1)
//                return i;
//        }
//
//        return -1;
//    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }

        return tmp;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1, 1, 2, 2, 3}));
    }
}
