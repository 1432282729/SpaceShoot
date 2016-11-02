package com.space.util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.game.player.bean.Player;
import com.space.game.server.GameServer;
import com.space.message.SendMessage;

import io.netty.channel.ChannelHandlerContext;

public class MessageUtils {
	
	private static Logger logger = Logger.getLogger(MessageUtils.class);
	
	
	public static void send(ChannelHandlerContext session, SendMessage message){
		
		if(session == null){
			return;
		}
		GameServer.SendMsgHandler(session, message);
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