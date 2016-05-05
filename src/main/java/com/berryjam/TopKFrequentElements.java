package com.berryjam;

import java.util.*;

/**
 * @author huangjinkun.
 * @date 16/5/5
 * @time 下午9:23
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums) {
            Integer cnt = map.get(num);
            if(cnt == null) {
                cnt = 0;
            }
            map.put(num, cnt+1);
        }
        Queue<Integer> pq = new PriorityQueue<Integer>(k+1, new Comparator<Integer>(){

            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Integer key:map.keySet()) {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int size = Math.min(k, pq.size());
        int[] items = new int[size];
        for(int i=size-1; i>=0; i--) {
            items[i] = pq.poll();
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = items.length - 1; i >= 0; i--) {
            result.add(items[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements app = new TopKFrequentElements();
//        System.out.println(app.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(app.topKFrequent(new int[]{3, 6, 7, 8, 8, 8, 3, 4, 6, 2, 2, 2, 2}, 4));
    }
}
