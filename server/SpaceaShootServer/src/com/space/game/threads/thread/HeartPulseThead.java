package com.space.game.threads.thread;

import java.util.Date;

import org.apache.log4j.Logger;

import com.space.game.player.bean.Player;
import com.space.game.struts.SessionAttribute;

import io.netty.channel.ChannelHandlerContext;

public class HeartPulseThead extends Thread {
	
	private static final Logger logger = Logger.getLogger(HeartPulseThead.class);
	private ChannelHandlerContext ctx;
	public HeartPulseThead(ChannelHandlerContext ctx){
		logger.info("启动用户心跳："+ctx.channel().id());
		this.ctx = ctx;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				Player player = ctx.attr(SessionAttribute.PLAYER).get();
				long lastHeartPulseTime = player.getLastHeartPulseTime();
				Date date = new Date();
				long intervalTime = date.getTime() - lastHeartPulseTime;
				if(player != null && player.isHeartPulse() && intervalTime > 10 * 1000){
					//大于十秒，判断用户断线，断开客户端连接
					logger.info("用户断开连接");
					player.setHeartPulse(false);
					ctx.close();		
					break;
				}else if(player.isHeartPulse() && intervalTime < 10 * 1000){
					player.setHeartPulse(false);
					player.setLastHeartPulseTime(lastHeartPulseTime);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
