package lang;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:53 2020/11/10
 */
public class ByteTest {

    @Test
    public void test () {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        char[] chars = new char[100];
        CharBuffer charBuffer1 = CharBuffer.wrap(chars,10,90);
        System.out.println(charBuffer1.length());

        CharBuffer charBuffer2 = CharBuffer.wrap("hello world");
        System.out.println(charBuffer2.length());





    }
}
