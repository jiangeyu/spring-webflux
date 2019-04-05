package think.in.java.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:23 2019/4/5
 */
public class FormattedMemoryInput {

    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                    BufferedInputFile.read("data.txt").getBytes()));

            while (true) {
                System.out.println(in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
