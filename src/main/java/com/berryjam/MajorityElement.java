package com.berryjam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/2/29
 * @time 下午1:39
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
        }
        int n = (nums.length - (nums.length / 2) * 2) > 0 ? (nums.length / 2 + 1) : nums.length / 2;
        for (Integer element : map.keySet()) {
            if (map.get(element) >= n) {
                return element;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement(new int[]{-1,1,1,1,2,1}));
    }
}
