package io;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;


public class SocketClient {

  public static void main(String[] args) throws IOException {
    String host = "127.0.0.1";
    int port = 8999;
    try {
      Socket client = new Socket(host, port);
      Writer writer = new OutputStreamWriter(client.getOutputStream());
      writer.write("hello world;");
      writer.flush();
      writer.close();
      client.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
