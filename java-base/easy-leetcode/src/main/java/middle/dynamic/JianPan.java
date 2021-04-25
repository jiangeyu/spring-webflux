package middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:44 2020/12/26
 */
public class JianPan {

    /**
     * 假设你有一个特殊的键盘包含下面的按键：
     * <p>
     * Key 1: (A)：在屏幕上打印一个 'A'。
     * <p>
     * Key 2: (Ctrl-A)：选中整个屏幕。
     * <p>
     * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
     * <p>
     * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
     * <p>
     * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
     * <p>
     * dp[i] 表示第操作后最多能显示多少个A
     *
     * @param N
     * @return
     */
    public static int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }



    public static void main(String[] args) {
        System.out.println(maxA(6));
        System.out.println(maxA(7));
    }


}
