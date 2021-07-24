package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/24 21:18
 */
public class FileChannelTest {

  public static void main(String[] args) throws Exception {
    String message = "hello world;";
    FileOutputStream fileOutputStream = new FileOutputStream("/Users/bytedance/1.txt");
    FileChannel fileChannel = fileOutputStream.getChannel();
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    byteBuffer.put(message.getBytes(StandardCharsets.UTF_8));
    byteBuffer.flip();
    fileChannel.write(byteBuffer);
    fileChannel.close();
    byteBuffer.clear();

    File file = new File("/Users/bytedance/1.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
    FileChannel fileChannel1 = fileInputStream.getChannel();
    fileChannel1.read(byteBuffer);
    System.out.println(new String(byteBuffer.array()));
    fileInputStream.close();
  }
}
