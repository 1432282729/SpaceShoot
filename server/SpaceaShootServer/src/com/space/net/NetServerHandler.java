package com.space.net;

import org.apache.log4j.Logger;

import com.space.game.server.GameServer;
import com.space.game.server.ManagerServer;
import com.space.message.ReceiveMessage;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NetServerHandler extends ChannelHandlerAdapter {
	
	private static Logger logger = Logger.getLogger(NetServerHandler.class);
	
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
    	
    	//玩家退出游戏
    	ManagerServer.playerServer.playerQuitGame(ctx);
    	
    }
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        
    	logger.info(ctx.channel().id()+"首次连接");
    }
    
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		ReceiveMessage rmsg = (ReceiveMessage) msg;
		//game线程
		GameServer.getInstance().ReceiveMsgHandler(ctx, rmsg);
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		logger.debug("异常...");
		cause.printStackTrace();
		ctx.close();
	}
}
