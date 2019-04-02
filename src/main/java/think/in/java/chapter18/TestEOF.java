package think.in.java.chapter18;

import java.io.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:20 2019/4/2
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {
        System.out.println("hhh".getBytes()[1]);
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                new FileInputStream("TestEOF.java")
        ));
        while (in.available() != 0) {
            System.out.println((char) in.readByte());
        }
    }
}
