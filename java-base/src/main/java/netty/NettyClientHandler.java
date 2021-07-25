package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/25 14:21
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//    super.channelRead(ctx, msg);
    ByteBuf byteBuffer = (ByteBuf) msg;
    System.out.println("remote address " + ctx.channel().remoteAddress());
    System.out.println("server reply " + byteBuffer.toString(CharsetUtil.UTF_8));
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    super.channelActive(ctx);
    System.out.println("client" + ctx);
    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,server", CharsetUtil.UTF_8));
  }
}
