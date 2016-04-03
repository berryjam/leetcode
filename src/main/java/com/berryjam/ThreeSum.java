package com.berryjam;

import java.util.*;

/**
 * @author huangjinkun.
 * @date 16/4/3
 * @time 下午2:05
 */
public class ThreeSum {

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Set<String> set = new HashSet<String>();
//
//        if (nums == null || nums.length <= 2) {
//            return result;
//        }
//
//        int[] tmp = new int[3];
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        tmp[0] = nums[i];
//                        tmp[1] = nums[j];
//                        tmp[2] = nums[k];
//                        Arrays.sort(tmp);
//                        if (!set.contains(tmp[0] + "," + tmp[1] + "," + tmp[2])) {
//                            set.add(tmp[0] + "," + tmp[1] + "," + tmp[2]);
//                            result.add(Arrays.asList(tmp[0], tmp[1], tmp[2]));
//                        }
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length <= 2) {
            return result;
        }

        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 2 && nums[index] <= 0; index++) {
            if (index >= 1 && nums[index] == nums[index - 1]) {
                continue;
            }

            List<int[]> doubleNums = twoSum(nums, -nums[index], index);
            for (int[] array : doubleNums) {
                result.add(Arrays.asList(nums[index], array[0], array[1]));
            }
        }


        return result;
    }

    public List<int[]> twoSum(int[] nums, int target, int index) {
        List<int[]> result = new ArrayList<int[]>();

        for (int i = index + 1, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == target) {
                result.add(new int[]{nums[i], nums[j]});
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
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
        System.out.println(threeSum.threeSum(new int[]{0,0,0}));
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
