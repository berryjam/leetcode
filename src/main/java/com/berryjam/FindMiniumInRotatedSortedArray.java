package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/4
 * @time 下午3:35
 */
public class FindMiniumInRotatedSortedArray {


    public int findMin(int[] nums) {
//        if (nums.length <= 0) {
//            return 0;
//        }
//
//        int result = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            result = Math.min(result, nums[i]);
//        }
//
//        return result;
        int low = 0, high = nums.length - 1;
        int min = nums[(nums.length - 1) / 2];
        while (low <= high) {
            int mid = (low + high) / 2;
            min = Math.min(min, nums[mid]);
            if (min < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMiniumInRotatedSortedArray array = new FindMiniumInRotatedSortedArray();
        System.out.println(array.findMin(new int[]{2, 1}));
    }
}
