package com.berryjam;

import java.util.Arrays;

/**
 * @author huangjinkun.
 * @date 16/4/18
 * @time 下午2:34
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = -1, end = -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                start = mid - 1;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                start++;

                end = mid + 1;
                while (end < nums.length && nums[end] == target) {
                    end++;
                }
                end--;

                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{start, end};
    }


    public static void main(String[] args) {
        SearchForARange app = new SearchForARange();
        System.out.println(Arrays.toString(app.searchRange(new int[]{1,1,2}, 1)));
        System.out.println(Arrays.toString(app.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
