package think.in.java.chapter18;

import java.io.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description: 存储和数据恢复
 * @Date: Created in 上午8:36 2019/4/2
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("data.txt")
                )
        );

        out.writeDouble(2.3);
        out.writeUTF("hello world");
        out.write(2);
        out.write(new byte[] {110,022});
        out.close();


        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("data.txt")
        ));

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }
}
