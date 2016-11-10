package com.space.game.threads.thread;

import org.apache.log4j.Logger;
import com.space.game.player.bean.Player;
import com.space.game.server.ManagerServer;
import com.space.game.struts.SessionAttribute;
import com.space.util.TimeUtil;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

/**
 * 心跳线程
 * @author Administrator
 *
 */
public class HeartPulseThead extends Thread {
	
	private static final Logger logger = Logger.getLogger(HeartPulseThead.class);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//心跳线程，一直启动
			while(true){
				
				Thread.sleep(5 * 1000);//每隔60秒检测心跳
				
				heartCheck();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void heartCheck(){
		ChannelGroup channelGroup = ManagerServer.channelGroup;
		for(Channel channel : channelGroup){
			Player player = channel.attr(SessionAttribute.PLAYER).get();
			if(player == null){
				continue;
			}
			long lastHeartPulseTime = player.getLastHeartPulseTime();
			long heartTime = TimeUtil.Time();
			long intervalTime = heartTime - lastHeartPulseTime;
			if(player.isOnLine() && intervalTime > 5 * 1000){
				//大于十秒，判断用户断线，断开客户端连接
				logger.info("用户 " + player.getName() + " 60秒未发送心跳，主动断开连接");
				channel.close();
			}
		}
	}
}
