package test;

import java.util.HashMap;
import java.util.Map;

import com.space.util.JsonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 处理客户端请求
 * @author 尹彬彬
 *
 */
public class ClientHandler extends ChannelHandlerAdapter {
	
    private final ByteBuf firstMessage;

    public ClientHandler() throws Exception {
    	
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("msgId", 201);
    	dataMap.put("datainfo", "dddddddddd");
    	String dataInfo = JsonUtil.parseObjectToJsonString(dataMap);
        byte[] req = dataInfo.getBytes("UTF-8");
        firstMessage = Unpooled.buffer(req.length+4);
        firstMessage.writeInt(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //与服务端建立连接后
        System.out.println("client channelActive..");
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("client channelRead..");
        //服务端返回消息后
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is :" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("client exceptionCaught..");
        ctx.close();
    }

	
}
