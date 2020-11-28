package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:12 2020/6/13
 */
public class AddTwoSumSolution1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        Integer length = nums.length;
        for (int j = 0; j < length; j++) {
            map.put(nums[j], j);
        }

        for (int j = 0; j < length; j++) {
            Integer number = target - nums[j];
            if (map.containsKey(number) && map.get(number) != j) {
                return new int[]{map.get(number), j};
            }

        }
        throw new IllegalArgumentException("no two sum solution");
    }


    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(twoSum(source, 5)));
    }
}

