package com.space.game.threads.thread;

import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.space.game.player.bean.Player;
import com.space.game.server.ManagerServer;
import com.space.game.struts.SessionAttribute;
import com.space.util.TimeUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;

public class HeartPulseThead extends Thread {
	
	private static final Logger logger = Logger.getLogger(HeartPulseThead.class);
/*	private ChannelHandlerContext ctx;
	public HeartPulseThead(ChannelHandlerContext ctx){
		this.ctx = ctx;
	}*/
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				
				
				Thread.sleep(2 * 1000);//每个10秒检测心跳
				
				heartCheck();
				
				/*Player player = ctx.attr(SessionAttribute.PLAYER).get();
				long lastHeartPulseTime = player.getLastHeartPulseTime();
				long heartTime = TimeUtil.Time();
				long intervalTime = heartTime - lastHeartPulseTime;
				if(player != null && !player.isHeartPulse() && intervalTime > 10 * 1000){
					//大于十秒，判断用户断线，断开客户端连接
					logger.info("用户 " + player.getName() + " 10秒未发送心跳，主动断开连接");
					this.ctx.close();		
					break;
				}else if(player.isHeartPulse() && intervalTime < 10 * 1000){
					//logger.info("接收到用户心跳:"+player.getName()+",间隔时间："+intervalTime);
					player.setHeartPulse(false);
					player.setLastHeartPulseTime(heartTime);
				}*/
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void heartCheck(){
		
		ChannelGroup channelGroup = ManagerServer.channelGroup;
		channelGroup.stream().filter(channel -> channel != null);
		
		//Object[] channels = channelGroup.toArray();
	}
	
	
	
}
