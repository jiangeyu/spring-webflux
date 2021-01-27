package middle.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:49 2021/1/27
 */
public class StringKuohao {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public static void generate(List<String> res, String ans, int count1, int count2, int n) {

        if (count1 > n || count2 > n) return;

        if (count1 == n && count2 == n) res.add(ans);


        if (count1 >= count2) {
            String ans1 = new String(ans);
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);

        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
