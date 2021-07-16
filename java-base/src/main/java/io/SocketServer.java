package io;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/** @Author PJX @Description @Date 2021/7/15 10:43 */
public class SocketServer {

  public static void main(String[] args) {
    String host = "127.0.0.1";
    int port = 8999;
    try {
      ServerSocket server = new ServerSocket(port);
      Socket socket = server.accept();
      Reader reader = new InputStreamReader(socket.getInputStream());

      char chars[] = new char[10];
      int len;
      StringBuilder sb = new StringBuilder();
      while ((len = reader.read(chars)) != -1) {
        sb.append(new String(chars, 0, len));
      }
      System.out.println(sb);
      reader.close();
      socket.close();
      server.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
