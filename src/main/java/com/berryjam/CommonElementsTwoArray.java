package com.berryjam;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 获取两个数组的公共元素
 *
 * @author huangjinkun.
 * @date 16/8/7
 * @time 上午11:24
 */
public class CommonElementsTwoArray {

    public static int[] getCommonElements(int[] array1, int[] array2) {
        List<Integer> list = Lists.newArrayList();
        Map<Integer, Boolean> map = Maps.newHashMap();
        if (array1.length > array2.length) {
            for (int i : array2) {
                map.put(i, true);
            }
            for (int i : array1) {
                if (map.containsKey(i)) {
                    list.add(i);
                }
            }
        } else {
            for (int i : array1) {
                map.put(i, true);
            }
            for (int i : array2) {
                if (map.containsKey(i)) {
                    list.add(i);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 5, 9, 11, 15, 28, 3};
        int[] array2 = new int[]{-1, 8, 9, 17, 11, 29, 0, -10, 101, 301};

        System.out.println(Arrays.toString(getCommonElements(array1, array2)));
    }
}
