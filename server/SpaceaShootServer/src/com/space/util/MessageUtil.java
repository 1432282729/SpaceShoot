package com.space.util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.game.server.GameServer;
import com.space.message.SendMessage;

import io.netty.channel.ChannelHandlerContext;

public class MessageUtil {
	
	private static Logger logger = Logger.getLogger(MessageUtil.class);
	
	
	public static void send(ChannelHandlerContext session, SendMessage message){
		
		if(session == null){
			return;
		}
		GameServer.getInstance().SendMsgHandler(session, message);
	}
	
	/*public static void sentToPlayer(Player player, JSONObject jsonObj){
		try {
			ChannelHandlerContext session = player.getIosession();
			SendMessage message = new SendMessage();
			message.setData(jsonObj.toString().getBytes("UTF-8"));
			send(session, message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	
	public static void sentMsg(ChannelHandlerContext session, JSONObject jsonObj){
		try {
			SendMessage message = new SendMessage();
			message.setData(jsonObj.toString().getBytes("UTF-8"));
			send(session, message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
}