package com.berryjam.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjinkun.
 * @date 16/4/16
 * @time 下午9:15
 */
public class Alibaba2015Ext3 {

    public void rpcSort(int[] requests) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int curSeq = 1;

        for (int i = 0; i < requests.length; i++) {
            if (requests[i] != curSeq) {
                map.put(requests[i], true);
            } else {
                if (map.get(requests[i] - 1) == null && map.get(requests[i] + 1) == null) {
                    System.out.println(requests[i]);
                    map.remove(requests[i]);
                    curSeq++;
                } else {
                    int low = requests[i] - 1;
                    while (map.get(low) != null) {
                        map.remove(low);
                        low--;
                    }
                    low++;

                    int high = requests[i] + 1;
                    while (map.get(high) != null) {
                        map.remove(high);
                        high++;
                    }
                    high--;

                    for (int j = low; j <= high; j++) {
                        if (j != high) {
                            System.out.print(j + ",");
                        } else {
                            System.out.print(j);
                        }
                    }

                    if (i != requests.length - 1) {
                        System.out.println();
                    }

                    curSeq = high + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Alibaba2015Ext3 app = new Alibaba2015Ext3();
        app.rpcSort(new int[]{1, 2, 5, 8, 10, 4, 3, 6, 9, 7});
    }
}
