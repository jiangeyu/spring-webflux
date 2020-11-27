package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:05 2020/11/27
 */
public class AAA {

    public static void main(String[] args) {

        System.out.println(removeVowels("aetgrtrtretdrtdtt"));
    }

    public static String removeVowels(String s) {
        char[] set = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : set) {
            list.add(c);
        }

        List<Character> ll = Arrays.asList(new Character [] {
                new Character('a'),
                new Character('e'),
                new Character('i'),
                new Character('o'),
                new Character('u')
        });

        list.removeAll(ll);
        StringBuilder result = new StringBuilder();
//        list.forEach(aa -> result.append(aa));

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i'||s.charAt(i) == 'o'||
                    s.charAt(i) == 'u') {
                continue;

            }
            result.append(s.charAt(i));
        }

        return result.toString();





    }
}
