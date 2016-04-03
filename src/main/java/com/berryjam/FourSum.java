package com.berryjam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基于ThreeSum扩展时，要注意i >= 1 && nums[i] == nums[i - 1]和index >= 2 && nums[index] == nums[index - 1]要作修改
 *
 * @author huangjinkun.
 * @date 16/4/3
 * @time 下午3:52
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> triples = threeSum(nums, target - nums[i], i);
                for (List<Integer> triple : triples) {
                    result.add(Arrays.asList(nums[i], triple.get(0), triple.get(1), triple.get(2)));
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        for (int index = start + 1; index < nums.length - 2; index++) {
            if (index == start + 1 || nums[index] != nums[index - 1]) {
                List<int[]> doubleNums = twoSum(nums, target - nums[index], index);
                for (int[] array : doubleNums) {
                    result.add(Arrays.asList(nums[index], array[0], array[1]));
                }
            }
        }


        return result;
    }

    public List<int[]> twoSum(int[] nums, int target, int index) {
        List<int[]> result = new ArrayList<int[]>();

        for (int l = index + 1, r = nums.length - 1; l < r; ) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                result.add(new int[]{nums[l], nums[r]});
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(fourSum.fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
