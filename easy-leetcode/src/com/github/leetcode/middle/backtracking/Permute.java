package com.github.leetcode.middle.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:11 2020/11/28
 */
public class Permute {
    /**
     * 回溯法算法
     * <p>
     * result = []
     * def backtrack (路径，选择列表)
     * if 满足条件
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表
     * 做选择
     * backtrack (路径，选择列表)
     * 撤销选择
     */

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path, num, result);
        return result;
    }

    public static void backtrack(LinkedList<Integer> path, int[] num, List<List<Integer>> result) {
        if (path.size() == num.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int select : num) {
            if (path.contains(select)) {
                continue;
            }
            path.add(select);
            backtrack(path, num, result);
            path.removeLast();
        }
    }


    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int select : num) {
            map.compute(select, (k, v) -> map.get(select) == null ? 1 : map.get(select) + 1);
        }
        backtrack1(path, num, result, map);
        return result;
    }

    public static void backtrack1(LinkedList<Integer> path, int[] num, List<List<Integer>> result, Map<Integer, Integer> map) {
        if (path.size() == num.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int select : num) {
            if (path.contains(select)) {
                continue;
            }
            path.add(select);
            backtrack1(path, num, result, map);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
//        System.out.println(permute(new int[]{ 1, 2, 3}));
        System.out.println(permute1(new int[]{1, 1, 2, 3}));

    }

}
