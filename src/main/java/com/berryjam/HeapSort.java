package com.berryjam;

import java.util.Arrays;

/**
 * @author huangjinkun.
 * @date 16/5/10
 * @time 下午4:01
 */
public class HeapSort {

    public int[] heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        buildHeap(array);
        int count = array.length;
        while (count - 1 > 0) {
            int tmp = array[0];
            array[0] = array[count - 1];
            array[count - 1] = tmp;
            count--;
            maxifyHeap(array, 0, count);
        }
        return array;
    }

    public void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxifyHeap(array, i, array.length);
        }
    }

    public void maxifyHeap(int[] array, int index, int size) {
        int tmp = array[index];
        while (index <= size / 2 - 1) {
            int max = array[2 * index + 1];
            int maxIndex = 2 * index + 1;
            if (2 * (index + 1) <= size - 1) { // 有右节点
                if (array[2 * index + 1] < array[2 * (index + 1)]) {
                    maxIndex = 2 * (index + 1);
                    max = array[2 * (index + 1)];
                }
            }
            if (tmp < max) {
                array[index] = max;
                index = maxIndex;
            } else {
                break;
            }
        }
        array[index] = tmp;
    }

    public static void main(String[] args) {
        HeapSort app = new HeapSort();
        System.out.println(Arrays.toString(app.heapSort(new int[]{2, 5, 3, 4, 8, 6, 10, 9, 1, 12, 12, 13})));
    }
}
