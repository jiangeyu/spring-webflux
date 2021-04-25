package middle.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:03 2021/1/11
 */
public class Egg {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1]; // dp[i][j] i 个鸡蛋扔 j 次能确定的最大区间的层数
        for (int j = 1; j <= N; j ++) {
            dp[0][j] = 0;
            for (int i = 1; i <= K; i ++) {
                // 如果碎了，确定 F 在碎的层数下面，即确定层数区间是 dp[i - 1][j - 1]
                // 如果没碎，确定 F 在扔的那一层 或者 扔的层数上面，即 1 + dp[i][j - 1]
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
                if (dp[i][j] >= N) {
                    return j;
                }
            }
        }
        return N;
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list=new ArrayList<>();
        int size=A.length-1;
        while(size>0){
            if(findIdexs(A,size)<size){
                list.add(findIdexs(A,size)+1);
                list.add(size+1);
            }
            reverse(A,0,findIdexs(A,size));
            reverse(A,0,size--);
        }
        return list;
    }
    public static int[] reverse(int[] A,int i,int j){
        for(;i<j;i++,j--){
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
        return A;
    }
    public static int findIdexs(int[] A,int size){
        int max=0,k=0;
        for(int i=0;i<=size;i++){
            if(max<A[i]){
                max=A[i];
                k=i;
            }
        }
        return k;
    }
}
