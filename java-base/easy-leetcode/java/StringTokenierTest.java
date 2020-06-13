import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:22 2020/6/13
 */
public class StringTokenierTest {

    @Test
    public void test () {
        String test = "hello,world;,ddd";
        StringTokenizer stringTokenizer = new StringTokenizer(test,",");
        if(stringTokenizer.countTokens() > 0) {
            String[] names = new String[stringTokenizer.countTokens()];
            for(int i =0;i<names.length;i++) {
                names[i] = stringTokenizer.nextToken();
            }

            for (String name : names) {
                System.out.println(name);
            }
        }


    }
}
