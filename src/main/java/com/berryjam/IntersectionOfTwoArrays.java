package com.berryjam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/5/18
 * @time 下午9:32
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }


        Map<Integer, Boolean> map1 = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> map2 = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> map3 = new HashMap<Integer, Boolean>();
        for (int i : nums1) {
            if (!map1.containsKey(i)) {
                map1.put(i, true);
            }
        }

        for (int i : nums2) {
            if (!map2.containsKey(i)) {
                map2.put(i, true);
            }
        }

        for (int i : nums1) {
            if (map1.containsKey(i) && map2.containsKey(i)) {
                map3.put(i, true);
            }
        }

        for (int i : nums2) {
            if (map1.containsKey(i) && map2.containsKey(i)) {
                map3.put(i, true);
            }
        }

        int[] result = new int[map3.size()];
        int index = 0;

        for (int i : map3.keySet()) {
            result[index++] = i;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
