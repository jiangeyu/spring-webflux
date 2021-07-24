package nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/24 16:44
 */
public class ByteBufferTest {
  public static void main(String[] args) {
    IntBuffer intBuffer = IntBuffer.allocate(10);
    intBuffer.put(1);
    intBuffer.put(2);
    intBuffer.put(3);
    intBuffer.put(4);
    System.out.println("position " + intBuffer.position());
    // 切换写模式为读模式,position=0,limit=position
    intBuffer.flip();
//    System.out.println(intBuffer.get(0));
//    System.out.println("position" + intBuffer.position());
//
//    System.out.println(intBuffer.get());
////    System.out.println(intBuffer.get(2));
//    intBuffer.mark();

//    System.out.println("position" + intBuffer.position());
    System.out.println(intBuffer.get());
    System.out.println(intBuffer.get());
//    intBuffer.rewind();
    System.out.println("position" + intBuffer.position());

  }
}
