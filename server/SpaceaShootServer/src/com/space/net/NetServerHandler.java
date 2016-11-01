package com.space.net;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NetServerHandler extends ChannelHandlerAdapter {
	@Override  
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {   
        //System.out.println(ctx.channel().id()+"进来了");  
    }  
      
    @Override  
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  
        //System.out.println(ctx.channel().id()+"离开了");  
    }  
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		System.out.println("server channelRead...");
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("The time server reveive order:" + body);
		String currentTime = "hello 00 1"+body;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("msgId", 110);
		dataMap.put("msgInfo", currentTime);
		String jsonText = JSON.toJSONString(dataMap, true);
		ByteBuf resp = Unpooled.copiedBuffer(jsonText.getBytes("UTF-8"));
		ctx.write(resp);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
		System.out.println("server channelReadComplete...");
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		System.out.println("server exceptionCaught..");
		cause.printStackTrace();
		ctx.close();
	}
}
