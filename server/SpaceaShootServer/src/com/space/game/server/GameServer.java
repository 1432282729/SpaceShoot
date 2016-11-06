package com.space.game.server;

import org.apache.log4j.Logger;

import com.space.db.DataBaseManager;
import com.space.message.MessageManager;
import com.space.message.ReceiveMessage;
import com.space.message.SendMessage;
import com.space.net.NetServer;
import com.space.thread.HandlerPool;

import io.netty.channel.ChannelHandlerContext;

public class GameServer implements Runnable {
	
	private final static Logger logger = Logger.getLogger(GameServer.class);
	private static final HandlerPool sendExcutor = new HandlerPool("消息发送队列", 10, -1);
	private static final HandlerPool receiveExcutor = new HandlerPool("消息接收队列", 10, -1);
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//加载handler
			MessageManager.getInstance().loadHandlerConfig();
			//加载数据库配置
			DataBaseManager.getInstance().loadDbConfig();
			//起服
			NetServer.getInstance().bind(9000);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//处理接收到的客户端消息
	public static void ReceiveMsgHandler(ChannelHandlerContext ctx, ReceiveMessage msg){
		int msgId = msg.getId();
		receiveExcutor.addTask(new ReceiveWorker(msgId,msg));
	}
	
	//发送客户端消息
	public static void SendMsgHandler(ChannelHandlerContext ctx, SendMessage msg){
		
		sendExcutor.addTask(new SendWorker(ctx, msg));
	}
	
	/**
     * 用枚举来实现单例
     */
    private enum Singleton {

        INSTANCE;
        GameServer processor;

        Singleton() {
            this.processor = new GameServer();
        }

        GameServer getProcessor() {
            return processor;
        }
    }
    
    public static GameServer getInstance() {
        return Singleton.INSTANCE.getProcessor();
    }
	
}
