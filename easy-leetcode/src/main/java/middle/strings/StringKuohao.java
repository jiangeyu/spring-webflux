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

    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * @param s
     * @param numRows
     * @return
     */

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int colLen = 2 * numRows - 2;  //每列的长度
        if (colLen == 0) colLen = 1;
        int n = s.length();
        int index;
        int minCol = n / colLen;   //共有多少完整列
        int ci = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < minCol + 1; j++) {
                index = j * colLen + i;
                if (index < s.length()) {
                    chars[ci++] = s.charAt(index);
                }
                if (i != 0 && i != numRows - 1) {
                    index = j * colLen + i + 2 * (numRows - i - 1);
                    if (index < s.length())
                        chars[ci++] = s.charAt(index);
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(convert("PAYPALISHIRING", 3));
    }

}
