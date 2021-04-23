package middle.backtracking.strings;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:23 2021/2/28
 */
public class IP {

    /**
     * 93. 复原 IP 地址
     * <p>
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     * <p>
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * <p>
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        // IPV4:点分十进制 1、4段 2、0 - 255 3、前缀不能为0
        if (s == null || s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backTracking(s, 0, res, new ArrayList<>());
        return res;
    }

    private void backTracking(String s, int index, List<String> res, List<String> ip) {
        if (index == s.length() && ip.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String num : ip) {
                sb.append(num + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }

        // 剪枝
        // 每段最多3个字符
        if (s.length() - index > 3 * (4 - ip.size())) {
            return;
        }
        // 每段最少1个字符
        if (s.length() - index < 4 - ip.size()) {
            return;
        }

        int num = 0;
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num < 0 || num > 255) {
                return;
            }
            // 前缀0
            if (i > index && s.charAt(index) == '0') {
                return;
            }
            ip.add(s.substring(index, i + 1));
            backTracking(s, i + 1, res, ip);
            ip.remove(ip.size() - 1);
        }
    }

    /**
     * 394. 字符串解码
     * <p>
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String string = "";
                while (!stack.peek().equals("[")) {
                    string = stack.pop() + string;
                }
                stack.pop();

                String countString = "";
                while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString = stack.pop() + countString;
                }
                int count = Integer.parseInt(countString);

                String retString = "";
                for (int j = 0; j < count; j++) {
                    retString = retString + string;
                }
                stack.push(retString);
            } else {
                String str = "" + s.charAt(i);
                stack.push(str);
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    /**
     * 242. 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 49. 字母异位词分组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

}
