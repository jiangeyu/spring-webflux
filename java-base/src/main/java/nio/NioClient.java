package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/** @Author PJX @Description @Date 2021/7/17 21:17 */
public class NioClient {

  public static void main(String[] args) throws IOException {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.configureBlocking(false);

    InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

    if (!socketChannel.connect(inetSocketAddress)) {
      while (!socketChannel.finishConnect()) {
        System.out.println("try to connect server");
      }
    }
    String message = "hello world!";
    ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
    socketChannel.write(byteBuffer);
    byteBuffer.flip();
    //    System.in.read();
    //    socketChannel.close();

  }
}
