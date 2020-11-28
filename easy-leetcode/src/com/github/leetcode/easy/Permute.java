package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] num) {
        LinkedList<Integer> path = new LinkedList<>();
        back(num, path);
        return res;
    }

    public static void back(int[] num, LinkedList<Integer> path) {
        if (path.size() == num.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (path.contains(num[i])) {
                continue;
            }
            path.add(num[i]);
            back(num, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));

    }

}
