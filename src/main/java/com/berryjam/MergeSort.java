package com.berryjam;

import java.util.Arrays;

/**
 * @author huangjinkun.
 * @date 16/5/14
 * @time 下午3:14
 */
public class MergeSort {

    public int[] mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        int start = 0, end = array.length - 1;
        mergeSort(array, tmp, start, end);
        return array;
    }

    public void mergeSort(int[] array, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, tmp, start, mid);
            mergeSort(array, tmp, mid + 1, end);
            int index = start;
            int l = start;
            int r = mid + 1;
            while (l <= mid && r <= end) {
                if (array[l] < array[r]) {
                    tmp[index++] = array[l++];
                } else {
                    tmp[index++] = array[r++];
                }
            }
            while (l <= mid) {
                tmp[index++] = array[l++];
            }
            while (r <= end) {
                tmp[index++] = array[r++];
            }
            for (int i = start; i <= end; i++) {
                array[i] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort app = new MergeSort();
        System.out.println(Arrays.toString(app.mergeSort(new int[]{2, 5, 3, 4, 8, 6, 10, 9, 1, 12, 12, 13})));
    }
}
