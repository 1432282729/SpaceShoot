package com.space.game.player.handler;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.message.MessageHandler;


public class LoginHandler extends MessageHandler {
	
	private static final Logger logger = Logger.getLogger("HandlerDealTime");
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		/*long start = TimeUtils.Time();
		ReceiveMessage rmsg = getMessage();
		ChannelHandlerContext context = rmsg.getContext();
		JSONObject jsonObj = (JSONObject) rmsg.getData();
		String playerId = jsonObj.getString("playerId");
		String password = jsonObj.getString("password");
		System.out.println("handler-->jsonObj="+jsonObj);
		Manager.scriptManager.call(ScriptEnum.PlayerScript, "checkLogin", context, playerId, password);
		long dealtime = TimeUtils.Time() - start;
		if (dealtime > 300) {
			logger.error("ReqActiveHandler deal long time:" + dealtime);
		}*/
	}

}
