package com.space.game.login.handler;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.game.server.ManagerServer;
import com.space.message.MessageHandler;
import com.space.message.ReceiveMessage;
import com.space.util.TimeUtil;


public class ReqLoginHandler extends MessageHandler {
	
	private static final Logger logger = Logger.getLogger(ReqLoginHandler.class);
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		long start = TimeUtil.Time();
		ReceiveMessage rmsg = getMessage();
		ChannelHandlerContext context = rmsg.getContext();
		JSONObject jsonObj = (JSONObject) rmsg.getData();
		String name = jsonObj.getString("name");
		String password = jsonObj.getString("pwd");
		
		ManagerServer.loginServer.login(context, name, password);
		
		long dealtime = TimeUtil.Time() - start;
		if (dealtime > 300) {
			logger.error("LoginHandler deal long time:" + dealtime);
		}
	}

}
