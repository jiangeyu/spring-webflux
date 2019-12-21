package com.github.lang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:03 2019/12/21
 */
public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        doConnect();

        try {
            while (!stop) {
                selector.select(100);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                if (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    handleInput(selectionKey);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleInput(SelectionKey selectionKey) {
        try {
            if (selectionKey.isValid()) {
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                if (selectionKey.isConnectable()) {
                    if (socketChannel.finishConnect()) {
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        doWrite(socketChannel);
                    } else {
                        System.exit(1);
                    }

                    if (selectionKey.isReadable()) {
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int readBytes = socketChannel.read(readBuffer);
                        if (readBytes > 0) {
                            readBuffer.flip();
                            byte[] bytes = new byte[readBuffer.remaining()];
                            readBuffer.get(bytes);
                            String body = new String(bytes, "UTF-8");
                            System.out.println(body);
                            this.stop = true;
                        } else if (readBytes < 0) {
                            selectionKey.cancel();
                            socketChannel.close();
                        } else {

                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void doConnect() {
        try {
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void doWrite(SocketChannel socketChannel) {
        try {
            byte[] request = "query time111 order".getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(request.length);
            writeBuffer.put(request);
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            if (!writeBuffer.hasRemaining()) {
                System.out.println("send order 2 server succeed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
