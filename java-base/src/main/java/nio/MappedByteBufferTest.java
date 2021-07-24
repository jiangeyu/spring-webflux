package nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/24 21:43
 */
public class MappedByteBufferTest {
  public static void main(String[] args) throws Exception {
    RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/bytedance/2.txt", "rw");

    FileChannel fileChannel = randomAccessFile.getChannel();
    MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
    mappedByteBuffer.put(0, (byte) 'H');
    mappedByteBuffer.put(3, (byte) '9');
    mappedByteBuffer.put(4, (byte) 'Y');

    randomAccessFile.close();
    System.out.println("success");
  }
}
