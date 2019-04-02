package think.in.java.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:58 2019/4/2
 */
public class UsingRandomAccessFile {

    static String file = "test.dat";

    static void display() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println(randomAccessFile.readDouble());

        }

        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");

        for (int i = 0; i < 7; i++) {
            rf.writeDouble(1.4141);
        }

        rf.writeUTF("hello world");
        rf.close();
        display();

        rf = new RandomAccessFile(file, "rw");
        rf.seek(5*8);
        rf.writeDouble(47.2);
        rf.close();
        display();

    }
}
