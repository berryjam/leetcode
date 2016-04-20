package com.berryjam;

import java.util.*;

/**
 * @author huangjinkun.
 * @date 16/4/3
 * @time 下午2:05
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length <= 2) {
            return result;
        }

        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 2 && nums[index] <= 0; index++) {
            if (index >= 1 && nums[index] == nums[index - 1]) { // 避免重复计算相同的三元组
                continue;
            }

            List<int[]> doubleNums = twoSum(nums, -nums[index], index);
            for (int[] array : doubleNums) {
                result.add(Arrays.asList(nums[index], array[0], array[1]));
            }
        }

        return result;
    }

    /**
     * twoSum，用于求threeSum
     *
     * @param nums   数组
     * @param target 目标
     * @param index  从index处往后求满足targer的two number
     * @return
     */
    public List<int[]> twoSum(int[] nums, int target, int index) {
        List<int[]> result = new ArrayList<int[]>();

        for (int i = index + 1, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == target) {
                result.add(new int[]{nums[i], nums[j]});
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) { // 避免重复计算
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) { // 避免重复计算
                    j--;
                }
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
