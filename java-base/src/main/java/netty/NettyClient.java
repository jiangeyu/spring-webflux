package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/25 00:55
 */
public class NettyClient {
  public static void main(String[] args) {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap
          .group(group)
          .channel(NioSocketChannel.class)
          .handler(
              new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                  socketChannel.pipeline().addLast(new NettyClientHandler());
                }
              });
      ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
      channelFuture.channel().closeFuture().sync();

    } catch (Exception e) {

    } finally {
      group.shutdownGracefully();
    }
  }
}
