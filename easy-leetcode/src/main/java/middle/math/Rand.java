package middle.math;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:18 2021/3/17
 */
public class Rand {


    /**
     * 470. 用 Rand7() 实现 Rand10()
     * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
     * <p>
     * 不要使用系统的 Math.random() 方法。
     *
     * @return
     */
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7() - 1;
            if (num < 40) return num % 10 + 1;
        }
    }

    public int rand7() {
        return 0;
    }


    /**
     * 50  pow(x,n)
     * <p>
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}
