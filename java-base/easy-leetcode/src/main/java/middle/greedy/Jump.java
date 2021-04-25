package middle.greedy;

import java.util.Arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:04 2020/12/19
 */
public class Jump {
    public static boolean canJump(int[] num) {
        int n = num.length;
        int further = 0;
        for (int i = 0; i < n - 1; i++) {
            further = Math.max(further, i + num[i]);
            if (further <= i) {
                return false;
            }
        }
        return further >= n - 1;
    }


    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int further = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            further = Math.max(further, i + nums[i]);
            if (end == i) {
                jumps++;
                end = further;
            }
        }
        return jumps;

    }


    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;

    }


    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * <p>
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        int pre = 1;
        int next = 2;
        for (int i = 2; i < n; i++) {
            int temp = next;
            next = (pre + next) % 1000000007;
            pre = temp;
        }
        return next;
    }

    /**
     * 134. 加油站
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * <p>
     * 补充两个问题（2019/5/26）：
     * <p>
     * 问题1: 为什么应该将起始站点设为k+1？
     * <p>
     * 因为k->k+1站耗油太大，0->k站剩余油量都是不为负的，每减少一站，就少了一些剩余油量。所以如果从k前面的站点作为起始站，剩余油量不可能冲过k+1站。
     * 问题2: 为什么如果k+1->end全部可以正常通行，且rest>=0就可以说明车子从k+1站点出发可以开完全程？
     * <p>
     * 因为，起始点将当前路径分为A、B两部分。其中，必然有(1)A部分剩余油量<0。(2)B部分剩余油量>0。
     * <p>
     * 所以，无论多少个站，都可以抽象为两个站点（A、B）。(1)从B站加满油出发，(2)开往A站，车加油，(3)再开回B站的过程。
     * <p>
     * 重点：B剩余的油>=A缺少的总油。必然可以推出，B剩余的油>=A站点的每个子站点缺少的油。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }

    /**
     * 136. 只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }

    /**
     * 零钱兑换
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = dp[i] + dp[i - coin];
                }

            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(3));//3
    }
}
