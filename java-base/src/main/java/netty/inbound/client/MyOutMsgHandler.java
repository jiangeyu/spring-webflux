package netty.inbound.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/7/25 22:38
 */
public class MyOutMsgHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("ChannelOutboundHandlerAdapter.read 发来一条消息\r\n");
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush("ChannelOutboundHandlerAdapter.write 发来一条消息\r\n");
        super.write(ctx, msg, promise);
    }

}
