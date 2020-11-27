package lang;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:39 2020/10/20
 */
public class ArrayTest {
    public static void main(String[] args) {

        int[] arr = (int[]) Array.newInstance(Integer.TYPE, 6);
        int[][] arr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{3, 2});
        System.out.println(arr.length);
        System.out.println(arr2[1].length);


    }
}
