package think.in.java.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:45 2019/4/5
 */
public class FileChannelDemo {


    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("file channel".getBytes()));
        fc.close();


        fc = new RandomAccessFile("data.txt", "rw").getChannel();

        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("file channel".getBytes()));
        fc.close();

         fc = new FileInputStream("data.txt").getChannel();
         ByteBuffer buff = ByteBuffer.allocate(1024);
         fc.read(buff);
         buff.flip();
         while (buff.hasRemaining()) {
             System.out.println((char)buff.get());
         }


    }
}
