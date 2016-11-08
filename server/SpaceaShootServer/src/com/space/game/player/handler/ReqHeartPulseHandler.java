package com.space.game.player.handler;
import org.apache.log4j.Logger;

import com.space.game.player.bean.Player;
import com.space.game.struts.SessionAttribute;
import com.space.message.MessageHandler;
import com.space.message.ReceiveMessage;
import com.space.util.TimeUtil;

import io.netty.channel.ChannelHandlerContext;

public class ReqHeartPulseHandler extends MessageHandler{
	
	private static final Logger logger = Logger.getLogger(ReqHeartPulseHandler.class);
	@Override
	public void action() {
		// TODO Auto-generated method stub
		long start = TimeUtil.Time();
		ReceiveMessage rmsg = getMessage();
		//获取player
		ChannelHandlerContext context = rmsg.getContext();
		Player player = context.attr(SessionAttribute.PLAYER).get();
		if(!player.isHeartPulse()){
			player.setHeartPulse(true);
		}
		
		long dealtime = TimeUtil.Time() - start;
		if (dealtime > 300) {
			logger.error("ReqHeartPulseHandler deal long time:" + dealtime);
		}
		
		
	}
	
}
