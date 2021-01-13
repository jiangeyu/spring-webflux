package middle.greedy;

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
        if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(3));//3
    }
}
