package com.berryjam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/3/4
 * @time 上午12:56
 */
public class ContainsDuplicate {

    public boolean containSDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                if (map.get(nums[i]).compareTo(1) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        System.out.println(duplicate.containSDuplicate(new int[]{1, 2, 3, 3}));
    }
}
