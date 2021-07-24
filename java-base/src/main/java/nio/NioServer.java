package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/** @Author PJX @Description @Date 2021/7/17 21:24 */
public class NioServer {

  public static void main(String[] args) throws IOException {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    Selector selector = Selector.open();

    serverSocketChannel.bind(new InetSocketAddress(6666));

    serverSocketChannel.configureBlocking(false);

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      while (selector.select(1000) == 0) {
        System.out.println("no client connect");
        continue;
      }

      Set<SelectionKey> selectionKeys = selector.selectedKeys();
      Iterator<SelectionKey> iterator = selectionKeys.iterator();
      while (iterator.hasNext()) {
        SelectionKey selectionKey = iterator.next();
        if (selectionKey.isAcceptable()) {
          SocketChannel socketChannel = serverSocketChannel.accept();
          socketChannel.configureBlocking(false);
          socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        }
        if (selectionKey.isReadable()) {
          SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
          ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
          socketChannel.read(byteBuffer);
          System.out.println("server receive data" + new String(byteBuffer.array()));
          byteBuffer.flip();
        }
        iterator.remove();

      }
    }
  }
}
