package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午11:15
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<=0){
            return -1;
        }

        for (int i = nums.length-1; i >=0; i--) {
            boolean changeFlag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                break;
            }
        }

        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        KthLargestElementInArray array = new KthLargestElementInArray();
        System.out.println(array.findKthLargest(new int[]{3,3,3,3,4,3,3,3,3}, 9));
        System.out.println(array.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(array.findKthLargest(new int[]{2,1}, 1));
        System.out.println(array.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(array.findKthLargest(new int[]{1}, 1));
    }
}
