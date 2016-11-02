package com.space.net;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.space.game.server.GameServer;
import com.space.message.ReceiveMessage;
import com.space.message.SendMessage;
import com.space.util.JsonUtil;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NetServerHandler extends ChannelHandlerAdapter {
	
	private static Logger logger = Logger.getLogger(NetServerHandler.class);
	
	@Override  
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {   
		logger.debug(ctx.channel().id()+"进来了");
    }  
      
    @Override  
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  
        logger.info(ctx.channel().id()+"离开了");
    }  
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        
    	logger.info(ctx.channel().id()+"首次连接");
    }
    
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		ReceiveMessage rmsg = (ReceiveMessage) msg;
		
/*		SendMessage sm = new SendMessage();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("msgId", 202);
		dataMap.put("name", "yoon");
		dataMap.put("cn", "银保部");
		String jsonStr = JsonUtil.parseObjectToJsonString(dataMap);
		sm.setData(jsonStr.getBytes("UTF-8"));
		GameServer.getInstance().SendMsgHandler(ctx, sm);*/
		
		GameServer.ReceiveMsgHandler(ctx, rmsg);
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		//logger.debug("server exceptionCaught...");
		cause.printStackTrace();
		ctx.close();
	}
}
