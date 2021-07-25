package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/25 14:13
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf byteBuf = (ByteBuf) msg;
    System.out.println("receive message " + byteBuf.toString(CharsetUtil.UTF_8));
//    super.channelRead(ctx, msg);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//    super.exceptionCaught(ctx, cause);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//    super.channelReadComplete(ctx);
    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client", CharsetUtil.UTF_8));

  }
}
