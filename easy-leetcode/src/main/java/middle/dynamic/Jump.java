package middle.dynamic;

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
            System.out.println(further);
            if (further <= i) {
                return false;
            }
        }
        return further >= n - 1;
    }
}
